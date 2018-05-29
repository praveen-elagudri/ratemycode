package com.ratemycode;


import com.ratemycode.commands.AboutDetails;
import com.ratemycode.commands.CompanyDetails;
import com.ratemycode.commands.JobDetails;
import com.ratemycode.commands.LoginCredentials;
import com.ratemycode.commands.SocialDetails;
import com.ratemycode.domain.AboutDetailsEntity;
import com.ratemycode.domain.CompanyDetailsEntity;
import com.ratemycode.domain.JobDetailsEntity;
import com.ratemycode.domain.SocialDetailsEntity;
import com.ratemycode.services.AboutDetailsService;
import com.ratemycode.services.CompanyDetailService;
import com.ratemycode.services.JobDetailService;
import com.ratemycode.services.LoginCredentialService;
import com.ratemycode.services.SocialDetailsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
public class RateMyCodeController {
    private LoginCredentialService loginService;
    private JobDetailService jobDetailService;
    private CompanyDetailService companyDetailService;
    private SocialDetailsService socialDetailsService;
    private AboutDetailsService aboutDetailsService;

    @Autowired
    public void setLoginService(LoginCredentialService loginService) {
		this.loginService = loginService;
	}

    @Autowired
	public void setJobDetailService(JobDetailService jobDetailService) {
		this.jobDetailService = jobDetailService;
	}

    @Autowired
	public void setSocialDetailsService(SocialDetailsService socialDetailsService) {
		this.socialDetailsService = socialDetailsService;
	}

    @Autowired
	public void setAboutDetailsService(AboutDetailsService aboutDetailsService) {
		this.aboutDetailsService = aboutDetailsService;
	}

    @Autowired
    public void setCompanyDetailService(CompanyDetailService companyDetailService) {
		this.companyDetailService = companyDetailService;
	}

    @GetMapping("test/{id}")
	public ResponseEntity<String> testing(@PathVariable("id") Integer id) {
		
		return new ResponseEntity<String>("working", HttpStatus.OK);
	}
	
	@PostMapping(path = "/login", consumes = "application/json", produces="application/json")
	public ResponseEntity<String> validateUser(@RequestBody LoginCredentials credentials ) {
		
		if(loginService.userExists(credentials.getEmail(),credentials.getPassword())) {
			System.out.println("Logged in successfully"+ credentials.getEmail()+credentials.getPassword());
			return new ResponseEntity<String>("success",HttpStatus.OK);
			
		} else {
			System.out.println("Logged in failed"+ credentials.getEmail()+credentials.getPassword());
			return new ResponseEntity<String>("failure",HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PostMapping(path = "/postjob", consumes = "application/json", produces="application/json")
	public ResponseEntity<String> addJobDetail(@RequestBody JobDetails jobdetail, UriComponentsBuilder builder) {
		
		System.out.println(jobdetail.toString());
		
		JobDetailsEntity savedJobDetail = jobDetailService.saveOrUpdateJobDetailForm(jobdetail);
		
       // boolean flag = articleService.addArticle(article);
        /*if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
       /* HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());*/
        return new ResponseEntity<String>("Successfully inserted job details", HttpStatus.CREATED);
	}
	
	@GetMapping("/getjob")
	public ResponseEntity<String> getJobDetails(@PathVariable("id") Integer id) {
		
		
		
		return new ResponseEntity<String>("working", HttpStatus.OK);
	}
	
	@GetMapping("solutions")
	public ResponseEntity<List<JobDetailsEntity>> getAllSolutions() {
		List<JobDetailsEntity> list = jobDetailService.listAll();
		return new ResponseEntity<List<JobDetailsEntity>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/savecompany", consumes = "application/json", produces="application/json")
	public ResponseEntity<String> addCompanyDetail(@RequestBody CompanyDetails companyDetail, UriComponentsBuilder builder) {
		System.out.println(companyDetail.toString());
		
		CompanyDetailsEntity savedCompanyDetail = companyDetailService.saveOrUpdateCompanyDetailForm(companyDetail);
		
       // boolean flag = articleService.addArticle(article);
        /*if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
       /* HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());*/
        return new ResponseEntity<String>("Successfully inserted company details", HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/company/all", produces="application/json")
	public ResponseEntity<String> aboutUs(@RequestBody AboutDetails aboutDetail, UriComponentsBuilder builder) {
		System.out.println(aboutDetail.toString());
		AboutDetailsEntity savedAboutDetail = aboutDetailsService.saveOrUpdateAboutDetailForm(aboutDetail);
        return new ResponseEntity<String>("Successfully inserted about us details", HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/socialnw", consumes = "application/json", produces="application/json")
	public ResponseEntity<String> aboutUs(@RequestBody SocialDetails socialDetail, UriComponentsBuilder builder) {
		System.out.println(socialDetail.toString());
		SocialDetailsEntity savedAboutDetail = socialDetailsService.saveOrUpdateSocialDetailForm(socialDetail);
        return new ResponseEntity<String>("Successfully inserted about social nw details", HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/company/{company}", produces="application/json")
	public ResponseEntity<List<JobDetailsEntity>> aboutUs(@PathVariable("company") String companyName) {
		System.out.println(companyName.toString());
		List<JobDetailsEntity> jobDetails = jobDetailService.listByCompanyName(companyName);
        return new ResponseEntity<List<JobDetailsEntity>>(jobDetails, HttpStatus.CREATED);
	}
	
	/*@RequestMapping("/")
    public String redirToList(){
        return "redirect:/product/list";
    }*/
	/*@RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid ProductForm productForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product/productform";
        }

        Product savedProduct = productService.saveOrUpdateJobDetailForm(productForm);

        return "redirect:/product/show/" + savedProduct.getId();
    }*/
}
