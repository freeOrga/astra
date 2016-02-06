package com.younes.app.rest;

import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.util.ajax.JSONObjectConvertor;
import org.joda.time.DateTime;

import com.younes.app.model.Department;
import com.younes.app.model.Employee;
import com.younes.app.model.Error;


//@Api( value = "/dept", description = "Manage departements" )
@Path("/dept")
public class EmployeeServiceRest {
	
	@POST
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json"})
	@Path("/employee")
	/*@ApiOperation( 

		    value = "Find person by e-mail", 

		    notes = "Find person by e-mail", 

		    response = Employee.class 

		)

		@ApiResponses( {

		    @ApiResponse( code = 404, message = "Person with such e-mail doesn't exists" )    

		} )
		*/
	public Employee getByName(@QueryParam("name") String name){
		return new Employee("eee", 6,5);
	}
	
	@GET
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json"})
	@Path("/depts/{test}/{first}/{last}")
	public Department getByName(@PathParam(value = "first") String firstName, @PathParam(value="last") String lastName){
		Employee e1 = new Employee(firstName, 30, 50000);
        Employee e2 = new Employee(lastName, 22, 40000);
 
        Department d = new Department();
        d.setName("Account");
        d.setDate(new DateTime(Calendar.getInstance().getTime()));
        d.getEmployees().add(e1);
        d.getEmployees().add(e2);
        
		return d;
	}
	
	
	@POST
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json"})
	@Path("/getbyemploye")
	public Department getByName(Employee e){
		Employee e1 = new Employee(e.getName(), 30, 50000);
 
        Department d = new Department();
        d.setName("Account");
        d.setDate(new DateTime(Calendar.getInstance().getTime()));
        d.getEmployees().add(e1);
        
		return d;
	}
	
	@POST
	@Produces({"application/json"})
	@Consumes({"application/xml","application/json"})
	@Path("/getbydept")
	public Response getDept(Department d){
		if(d.getEmployees().size()==0){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		Employee e = new Employee(d.getEmployees().get(0).getName(), d.getEmployees().get(0).getAge(), d.getEmployees().get(0).getSalary());
		
		if(e.getName().equals("test")){
			/*JSONObject json = new JSONObject();
			json.put("status", "error");
	        json.put("code", Response.Status.NOT_FOUND.getStatusCode());
	        json.put("message", "User " + authData.getString("email") + " not found.");
	        */
			Error err = new Error();
			err.setCode("FWLK01");
			err.setMessage("not found element");
	        return Response.status(Response.Status.NOT_FOUND).entity(err).build();
           // return Response.status(Response.Status.BAD_REQUEST).entity(json.toString()).build();
        }else{
            return Response.ok(e).build();
        }
        
	}
	
	

}
