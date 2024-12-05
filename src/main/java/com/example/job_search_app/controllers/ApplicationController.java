package com.example.job_search_app.controllers;

import com.example.job_search_app.dto.ApplicationDTO;
import com.example.job_search_app.services.ApplicationService;
import com.example.job_search_app.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.BASED_URL+Constants.USERS+"/{userId}"+Constants.APPLICATIONS)
public class ApplicationController {
	private final ApplicationService applicationService;

	@GetMapping
	public List<ApplicationDTO> getAll(@PathVariable int userId){
		return applicationService.getAll(userId);
	}

	@GetMapping("/{applicationId}")
	public ApplicationDTO getById(@PathVariable("applicationId") Long id){
		return applicationService.getOne(id);
	}
	@PostMapping
	public void Insert(@PathVariable int userId, @RequestBody ApplicationDTO applicationDto){
		applicationService.insert(userId, applicationDto);
	}

	@PutMapping("/{applicationId}")
	public void updateApplication(@PathVariable int userId, @PathVariable Long applicationId, @RequestBody ApplicationDTO applicationDto){
		applicationService.updateApplication(userId, applicationId, applicationDto);
	}

	@DeleteMapping("/{applicationId}")
	public void deleteApplicationById(@PathVariable("applicationId") Long id){
		applicationService.deleteApplicationById(id);
	}
}
