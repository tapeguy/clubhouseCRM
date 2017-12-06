package edu.fhsu.csci466.clubhouse.crm.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fhsu.csci466.clubhouse.crm.service.MemberService;
import edu.fhsu.csci466.clubhouse.crm.service.model.EntityList;
import edu.fhsu.csci466.clubhouse.crm.service.model.Member;

/**
 * @author scottKC
 *
 */
@RestController
@RequestMapping("/crm")
public class MemberRestController {
	private final MemberService service;

	/**
	 * @param service
	 */
	@Autowired
	public MemberRestController(MemberService service) {
		this.service = service;
	}

	/**
	 * @param lastName
	 * @return list of all member
	 */
	@GetMapping(value = "/member", produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<EntityList<Member>> getMembers() {
		EntityList<Member> list = new EntityList<>(service.getMembers());
		for (Member member : list.getEntities()) {
			member.add(linkTo(
					methodOn(MemberRestController.class).getMember(member.getMemberId()))
							.withSelfRel());
		}
		list.add(linkTo(methodOn(MemberRestController.class).getMembers())
				.withRel("list"));
		list.add(linkTo(methodOn(MemberRestController.class).addMember(null))
				.withRel("add"));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	/**
	 * @param member
	 * @return response entity the status to return
	 */
	@PostMapping(value = "/member", produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Member> addMember(@RequestBody Member member) {
		HttpStatus status = service.addMember(member) ? HttpStatus.OK
				: HttpStatus.INTERNAL_SERVER_ERROR;
		member.add(linkTo(
				methodOn(MemberRestController.class).getMember(member.getMemberId()))
						.withSelfRel());
		return new ResponseEntity<>(member, status);
	}

	/**
	 * @param id
	 * @return member
	 */
	@GetMapping(value = "/member/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Member> getMember(@PathVariable Long id) {
		Member member = service.getMember(id);
		HttpStatus status = (member != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		member.add(
				linkTo(methodOn(MemberRestController.class).getMember(id)).withSelfRel());
		return new ResponseEntity<>(member, status);
	}

	/**
	 * @param member
	 * @return response entity the status to return
	 */
	@PutMapping(value = "/member", produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Member> updateMember(@RequestBody Member member) {
		HttpStatus status = service.updateMember(member) ? HttpStatus.OK
				: HttpStatus.NOT_FOUND;
		member.add(linkTo(
				methodOn(MemberRestController.class).getMember(member.getMemberId()))
						.withSelfRel());
		return new ResponseEntity<>(member, status);
	}

	/**
	 * @param id
	 * @param newPassword
	 * @return HttpStatus
	 *
	 */
	// This should be using HTTPS.
	@PutMapping(value = "/member/{id}/password/{newPassword}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Member> updateMemberPassword(@PathVariable Long id,
			@PathVariable String newPassword) {
		// set HttpStatus based on success of update
		// service handles password encryption prior to saving to the db.
		HttpStatus status = service.updateMemberPassword(id, newPassword) ? HttpStatus.OK
				: HttpStatus.NOT_FOUND;

		// fetch updated member from db and add link
		Member member = service.getMember(id);
		member.add(linkTo(
				methodOn(MemberRestController.class).getMember(member.getMemberId()))
						.withSelfRel());

		return new ResponseEntity<>(member, status);
	}

	/**
	 * @param id
	 * @return response entity the status to return
	 */
	@DeleteMapping(value = "member/{id}")
	public HttpEntity<Member> deleteMember(@PathVariable Long id) {
		Member member = service.getMember(id);
		HttpStatus status = service.deleteMember(member) ? HttpStatus.OK
				: HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(status);
	}

	/**
	 * @param id
	 * @param payment
	 * @return response entity
	 */
	@PutMapping(value = "/member/{id}/pay/{payment}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Member> makePayment(@PathVariable Long id,
			@PathVariable Double payment) {
		Member member = service.getMember(id);
		HttpStatus status;
		if (PaymentUtil.isValidPayment(payment)) {
			if (member != null) {
				member = PaymentUtil.makePayment(member, payment);
				status = service.updateMember(member) ? HttpStatus.OK
						: HttpStatus.I_AM_A_TEAPOT;
			}
			else
				status = HttpStatus.NOT_FOUND;
		}
		else {
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(member, status);
	}
}
