package za.ac.nwu.web.sb.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.persistence.AccountType;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.CreateAccountTypeFlow;
import za.ac.nwu.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.logic.flow.impl.ModifyAccountTypeFlow;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("account-type")
public class DemoController {

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;

    @Autowired
    public DemoController(FetchAccountTypeFlow fetchAccountTypeFlow,
                          @Qualifier("createAccountTypeFlowName") CreateAccountTypeFlow createAccountTypeFlow){
        this.fetchAccountTypeFlow= fetchAccountTypeFlow;
        this.createAccountTypeFlow= createAccountTypeFlow;
    }
    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured account types", notes = "Returns a list of account types")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message= "Bad Request", response= GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internet server error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll(){
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new account type", notes = "Creates a new AccountType int the DB")
    @ApiResponses(value = {
            @ApiResponse(code= 201, message= "The AccountType has created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code= 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request body to create a new AccountType",
                required = true)
            @RequestBody AccountTypeDto accountType) {
        AccountTypeDto accountTypeResponse = createAccountTypeFlow.create(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("Account_Type_ID")
    @ApiOperation(value = "Gets all the configured account types", notes = "Returns a list of account types")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message= "Bad Request", response= GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internet server error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
            @ApiParam(value = "The account type ID that uniquely identifies the AccountType,",
                    example = "MILES",
                    name = "Account_Type_ID",
                    required = true)
            @PathVariable("Account_Type_ID") final String Account_TypeID){
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Gets all the configured account types", notes = "Returns a list of account types")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message= "Bad Request", response= GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internet server error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> createAccountType(
            @ApiParam(value = "The account type ID that uniquely identifies the AccountType,",
                    example = "MILES",
                    name = "Account_Type_ID",
                    required = true)
            @PathVariable("Account_Type_ID") final String Account_TypeID){
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("Account_Type_ID")
    @ApiOperation(value = "Gets all the configured account types", notes = "Returns a list of account types")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message= "Bad Request", response= GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internet server error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> deleteAccountType(
            @ApiParam(value = "The account type ID that uniquely identifies the AccountType,",
                    example = "MILES",
                    name = "Account_Type_ID",
                    required = true)
            @PathVariable("Account_Type_ID") final String Account_TypeID){
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("Account_Type_ID")
    @ApiOperation(value = "Gets all the configured account types", notes = "Returns a list of account types")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message= "Bad Request", response= GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internet server error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> updateAccountType(
            @ApiParam(value = "The account type ID that uniquely identifies the AccountType,",
                    example = "MILES",
                    name = "Account_Type_ID",
                    required = true)
            @PathVariable("Account_Type_ID") final String Account_TypeID,
            @ApiParam(value =  "The new AccountTypeName that he specified AccountType should be updated with.",
                    name = "newAccountTypeName",
                    required = true)
            @RequestParam("newAccountTypeName") final String newAccountTypeName,

            @ApiParam(value = "The optional new date with which to update the StartDate in ISO date format (yyyy-MM-dd).",
                    name = "newStartDate")
             @RequestParam(value = "newStartDate", required = false)
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate newStartDate)
    {
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
