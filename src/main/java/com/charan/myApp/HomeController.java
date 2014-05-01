package com.charan.myApp;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import com.me.others.*;
import com.charan.Business.DrugOrder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.charan.Business.Drug;
import com.charan.Business.DrugPackage;
import com.charan.Business.Employee;
import com.charan.Business.Enterprise;

import com.charan.Business.DrugOrder;
import com.charan.Business.Location;
import com.charan.Business.OrderItem;
import com.charan.Business.PackageHistory;
import com.charan.Business.PackageTransaction;
import com.charan.Business.Patient;
import com.charan.Business.Person;
import com.charan.Business.PurchaseOrderRequest;
import com.charan.Business.ShippingRequest;
import com.charan.Business.UserAccount;
import com.charan.Business.WorkRequest;
import com.charan.DAO.DrugDAO;
import com.charan.DAO.DrugOrderDAO;
import com.charan.DAO.DrugPackageDAO;
import com.charan.DAO.EmployeeDAO;
import com.charan.DAO.EnterpriseDAO;
import com.charan.DAO.OrderItemDAO;
import com.charan.DAO.PackageHistoryDAO;
import com.charan.DAO.PackageTransactionDAO;
import com.charan.DAO.PatientDAO;
import com.charan.DAO.PersonDAO;
import com.charan.DAO.PurchaseOrderRequestDAO;
import com.charan.DAO.ShippingRequestDAO;
import com.charan.DAO.UserAccountDAO;
import com.charan.DAO.WorkRequestDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired 
	private UserAccountDAO userAccountDAO;
	@Autowired 
	private EnterpriseDAO enterpriseDAO;
	@Autowired 
	private EmployeeDAO employeeDAO;
	@Autowired 
	private PatientDAO patientDAO;
	@Autowired 
	private PersonDAO personDAO;
	@Autowired 
	private DrugDAO drugDAO;
	@Autowired 
	private DrugPackageDAO drugPackageDAO;
	@Autowired 
	private WorkRequestDAO workRequestDAO;
	@Autowired 
	private DrugOrderDAO drugOrderDAO;
	@Autowired 
	private OrderItemDAO orderItemDAO;
	@Autowired 
	private PurchaseOrderRequestDAO purchaseOrderRequestDAO;
	@Autowired 
	private PackageHistoryDAO packageHistoryDAO;
	@Autowired 
	private PackageTransactionDAO packageTransactionDAO;
	@Autowired 
	private ShippingRequestDAO shippingRequestDAO;
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
	/*	
		Location l1=new Location();
		l1.setLine1("l1");
		l1.setLine2("l1");
		l1.setCity("l1");
		l1.setState("l1");
		l1.setZip("l1");
		
		
	
		Enterprise enterprise1=new Enterprise();
		enterprise1.setEnterpriseName("Business");
		//enterprise1.setLocation(l1);
		enterprise1.setType("Business");
		enterpriseDAO.persist(enterprise1);
		
		Enterprise enterprise2=new Enterprise();
		enterprise2.setEnterpriseName("m1");
		//enterprise2.setLocation(l1);
		enterprise2.setType("Manufacturer");
		enterpriseDAO.persist(enterprise2);
		
		Enterprise enterprise3=new Enterprise();
		enterprise3.setEnterpriseName("m2");
		//enterprise3.setLocation(l1);
		enterprise3.setType("Manufacturer");
		enterpriseDAO.persist(enterprise3);
		
		Enterprise enterprise4=new Enterprise();
		//enterprise4.setLocation(l1);
		enterprise4.setEnterpriseName("d1");
		enterprise4.setType("Distributor");
		enterpriseDAO.persist(enterprise4);
		
		Enterprise enterprise5=new Enterprise();
		enterprise5.setEnterpriseName("d2");
		//enterprise5.setLocation(l1);
		enterprise5.setType("Distributor");
		enterpriseDAO.persist(enterprise5);
		
		Employee emp1=new Employee();
		emp1.setfName("admin");
		emp1.setlName("admin");
		
	//	emp1.setLocation(l1);
		
		emp1.setEnterprise(enterprise1);
		employeeDAO.persist(emp1);

		
		Employee emp2=new Employee();
		emp2.setfName("m1");
		emp2.setlName("m1");
		
		//emp2.setLocation(l1);
		
		emp2.setEnterprise(enterprise2);
		employeeDAO.persist(emp2);
		

		Employee emp3=new Employee();
		emp3.setfName("m2");
		emp3.setlName("m2");
		
		//emp3.setLocation(l1);
		
		emp3.setEnterprise(enterprise3);
		employeeDAO.persist(emp3);
		
		Employee emp4=new Employee();
		emp4.setfName("d1");
		emp4.setlName("d1");
		
		//emp4.setLocation(l1);
		
		emp4.setEnterprise(enterprise4);
		employeeDAO.persist(emp4);
		
		Employee emp5=new Employee();
		emp5.setfName("d2");
		emp5.setlName("d2");
		
		//emp5.setLocation(l1);
		
		emp5.setEnterprise(enterprise5);
		employeeDAO.persist(emp5);
		
		UserAccount ua1=new UserAccount();
		ua1.setUsername("admin");
		ua1.setPassword("admin");
		ua1.setRole("Admin");
		ua1.setEnterprise(enterprise1);
		Person person1=personDAO.findPersonById(emp1.getId());
		ua1.setPerson(person1);
		
		userAccountDAO.persist(ua1);
		DrugOrder o=new DrugOrder();
		drugOrderDAO.persist(o);
		
		Enterprise fda=new Enterprise();
		fda.setEnterpriseName("FDA");
		fda.setType("FDA");
		enterpriseDAO.persist(fda);
		
		Employee fdaemp=new Employee();
		fdaemp.setfName("fda");
		fdaemp.setfName("fda");
		fdaemp.setEnterprise(fda);
		employeeDAO.persist(fdaemp);
		
		Person fdp=personDAO.findPersonById(fdaemp.getId());
		
		UserAccount fdaua=new UserAccount();
		fdaua.setUsername("f1");
		fdaua.setPassword("f1");
		fdaua.setEnterprise(fda);
		fdaua.setPerson(fdp);
		fdaua.setRole("FDA");
		
		userAccountDAO.persist(fdaua);
		*/
		
		return "login";
	}
	
	@RequestMapping(value = "/login1", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {
		
		
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		UserAccount user=userAccountDAO.findUserAccountByUsername(userName);
		
		if(user.getPassword().equals(password)){
		
			request.getSession().setAttribute("user", user);
			if(user.getRole().equals("Admin")){
			return "admin_home";
			}else if(user.getRole().equals("Manufacturer")){
				return "manufacturer_home";
			}else if(user.getRole().equals("Distributor")){
				return "distributor_home";
			}else if(user.getRole().equals("Hospital")){
				return "hospital_home";
			}else if(user.getRole().equals("FDA")){
				return "fda_home";
			}else if(user.getRole().equals("Patient")){
				return "patient_home";
			}else{
				return "";
			}
		
		}else{

		return "login";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		
		request.getSession().setAttribute("user", null);
		
		return "login";
	}
	
	@RequestMapping(value = "/admin_enterprise", method = RequestMethod.GET)
	public String admin_enterprise(HttpServletRequest request, Model model) {
	
		return "admin_enterprise"; 
	}
	@RequestMapping(value = "/admin_employee", method = RequestMethod.GET)
	public String admin_employee(HttpServletRequest request, Model model) {
	
		return "admin_employee"; 
	}
	@RequestMapping(value = "/admin_patient", method = RequestMethod.GET)
	public String admin_patient(HttpServletRequest request, Model model) {
	
		return "admin_patient"; 
	}
	@RequestMapping(value = "/admin_user", method = RequestMethod.GET)
	public String admin_user(HttpServletRequest request, Model model) {
	
		return "admin_user"; 
	}
	@RequestMapping(value = "/admin_list", method = RequestMethod.GET)
	public String admin_cr_list(HttpServletRequest request, Model model) {
	
		return "admin_list"; 
	}
	
	@RequestMapping(value = "/admin_cr_enterprise", method = RequestMethod.POST)
	public String admin_cr_enterprise(HttpServletRequest request, Model model) {
	Enterprise enterprise=new Enterprise();
	enterprise.setEnterpriseName(request.getParameter("enterpriseName"));
	enterprise.setStatus(request.getParameter("status"));
	enterprise.setType(request.getParameter("enterpriseType"));
	
	Location l1=new Location();
	l1.setLine1(request.getParameter("line1"));
	l1.setLine2(request.getParameter("line2"));
	l1.setCity(request.getParameter("city"));
	l1.setState(request.getParameter("state"));
	l1.setZip(request.getParameter("zip"));
	
	enterprise.setLocation(l1);
		
	enterpriseDAO.persist(enterprise);
		
		return "admin_employee"; 
	}
	@RequestMapping(value = "/admin_cr_employee", method = RequestMethod.POST)
	public String admin_cr_employee(HttpServletRequest request, Model model) {
	
		Employee emp1=new Employee();
		emp1.setfName(request.getParameter("fName"));
		emp1.setlName(request.getParameter("lName"));
		emp1.setDob(request.getParameter("dob"));
		Location l1=new Location();
		l1.setLine1(request.getParameter("line1"));
		l1.setLine2(request.getParameter("line2"));
		l1.setCity(request.getParameter("city"));
		l1.setState(request.getParameter("state"));
		l1.setZip(request.getParameter("zip"));
		emp1.setLocation(l1);
		int entId=Integer.parseInt(request.getParameter("selectedenterprise"));
		Enterprise enterprise=enterpriseDAO.findEnterpriseById(entId);
		emp1.setEnterprise(enterprise);
		
		List <Employee> employeeList=new ArrayList<Employee>();
		employeeList.add(emp1);
		enterprise.setEmployeeList(employeeList);
		
		enterpriseDAO.update(enterprise);
		
		return "admin_user"; 
	}
	
	@RequestMapping(value = "/cr_patient", method = RequestMethod.POST)
	public String admin_cr_patient(HttpServletRequest request, Model model) {
		
		Enterprise enterprise=enterpriseDAO.findEnterpriseById(1);
		Patient pat=new Patient();
		pat.setfName(request.getParameter("fName"));
		pat.setlName(request.getParameter("lName"));
		pat.setDob(request.getParameter("dob"));
		Location l1=new Location();
		l1.setLine1(request.getParameter("line1"));
		l1.setLine2(request.getParameter("line2"));
		l1.setCity(request.getParameter("city"));
		l1.setState(request.getParameter("state"));
		l1.setZip(request.getParameter("zip"));
		pat.setLocation(l1);
		patientDAO.persist(pat);
		
		UserAccount ua=new UserAccount();
		ua.setUsername(request.getParameter("uName"));
		ua.setPassword(request.getParameter("password"));
		ua.setRole("Patient");
		Person p=personDAO.findPersonById(pat.getId());
		ua.setPerson(p);
		ua.setEnterprise(enterpriseDAO.findEnterpriseById(1));
		userAccountDAO.persist(ua);
		
		return "admin_home"; 
	}
	@RequestMapping(value = "/admin_cr_user", method = RequestMethod.POST)
	public String admin_cr_user(HttpServletRequest request, Model model) {
	
	int entid=Integer.parseInt(request.getParameter("listenterprise"));
		Enterprise enterprise=enterpriseDAO.findEnterpriseById(entid);
		Employee employee=employeeDAO.findEmployeeById(Integer.parseInt(request.getParameter("listemployee")));
		Person person=personDAO.findPersonById(employee.getId());
		UserAccount ua=new UserAccount();
		ua.setUsername(request.getParameter("username"));
		ua.setPassword(request.getParameter("password"));
		ua.setEnterprise(enterprise);
		ua.setPerson(person);
		
		ua.setRole(enterprise.getType());
		
		List<UserAccount> userList=new ArrayList<UserAccount>();
		userList.add(ua);
		
		enterprise.setUserList(userList);
		
		enterpriseDAO.update(enterprise);
		
		return "admin_home"; 
	}
	
	 @RequestMapping(value = "/getEnterpriseType", method = RequestMethod.GET)
		public @ResponseBody String getEnterpriseType( @RequestParam("enttype")String chars) {
	          List<Enterprise> list=enterpriseDAO.findEnterpriseListByType(chars);
		 HashMap<String, Integer> hash=new HashMap<String, Integer>();
		 for(Enterprise e: list){
			 hash.put(e.getEnterpriseName(), e.getId());
		 }
	          
	             return new Gson().toJson(hash);
	         }
	 
	 @RequestMapping(value = "/getEmployeeByEnterprise", method = RequestMethod.GET)
		public @ResponseBody String getEmployeeByEnterprise( @RequestParam("ent")String chars) {
	          List<Employee> list=employeeDAO.findEmployeeByEnterprise(chars);
		 HashMap<String, Integer> hash=new HashMap<String, Integer>();
		 for(Employee e: list){
			 hash.put(e.getlName()+", "+e.getfName(), e.getId());
		 }
	          
	             return new Gson().toJson(hash);
	         }
	 
	 @RequestMapping(value = "/cr_drug", method = RequestMethod.POST)
		public String cr_drug(HttpServletRequest request, Model model) {
		UserAccount ua=(UserAccount)request.getSession().getAttribute("user");
		 
		Drug drug=new Drug();
		drug.setCompound(request.getParameter("compound"));
		drug.setName(request.getParameter("name"));
		drug.setDosage(request.getParameter("dosage"));
		drug.setLife(Integer.parseInt(request.getParameter("life")));
		drug.setWeight(request.getParameter("weight"));
		
		drug.setManufacturer(ua.getEnterprise());
		
		List<Drug> drugList=new ArrayList<Drug>();
		drugList.add(drug);
		
		ua.getEnterprise().setDrugList(drugList);
		
		enterpriseDAO.update(ua.getEnterprise());
		
		 return "manufacturer_home";
	 }
	 
	 @RequestMapping(value = "/manufacturer_drug", method = RequestMethod.GET)
		public String manufacturer_drug(HttpServletRequest request, Model model) {
		 return "manufacturer_drug";
	 }
	 @RequestMapping(value = "/manufacturer_catalog1", method = RequestMethod.GET)
		public String manufacturer_catalog(HttpServletRequest request, Model model) {
		 Object obj=(request.getSession(false).getAttribute("user"));
		 Enterprise ent=((UserAccount)obj).getEnterprise() ;
		 request.getSession(false);
	          List<Drug> list=drugDAO.findDrugByEnterprise(ent.getId());
	          
	          model.addAttribute("list",list);
		 
		 return "manufacturer_catalog";
	 }
	 @RequestMapping(value = "/manufacturer_home", method = RequestMethod.GET)
		public String manufacturer_home(HttpServletRequest request, Model model) {
		
		 return "manufacturer_home";
	 }
	 @RequestMapping(value = "/distributor_home", method = RequestMethod.GET)
		public String distributor_home(HttpServletRequest request, Model model) {
		
		 return "distributor_home";
	 }
	 @RequestMapping(value = "/distributor_order", method = RequestMethod.GET)
		public String distributor_order(HttpServletRequest request, Model model) {
		List<Enterprise> manufacturerList=enterpriseDAO.findEnterpriseListByType("Manufacturer");
		
		 model.addAttribute("list", manufacturerList);
		 request.getSession().removeAttribute("cart");
		 return "distributor_order";
	 }
	 
	 
	 @RequestMapping(value = "/getDrugsByEnterprise", method = RequestMethod.GET)
		public @ResponseBody String getDrugsByEnterprise(@RequestParam("entid")String chars,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		 
		 request.getSession().setAttribute("cart", null);
		
	          List<Drug> list=drugDAO.findDrugByEnterprise(Integer.parseInt(chars));
//		 HashMap<String, Integer> hash=new HashMap<String, Integer>();
//		 for(Enterprise e: list){
//			 hash.put(e.getEnterpriseName(), e.getId());
//		 }
//	          List<Drug> tempList=new ArrayList<Drug>();
//	          for(Drug d:list){
//	        	  List<OrderItem> t1=new ArrayList<OrderItem>();
//	        	  List<DrugPackage> t2=new ArrayList<DrugPackage>();
//	        	  d.setOrderItems(t1);
//	        	  d.setPackageList(t2);
//	        	  tempList.add(d);
//	          }
	        //  Hibernate.initialize(list);
	          
	        	/*GsonBuilder gsonBuilder= new GsonBuilder();
	        	
	        	new GraphAdapterBuilder()
	          .addType(Enterprise.class)
	          .registerOn(gsonBuilder);
	        	Gson gson=gsonBuilder.serializeNulls().create();
	          String json=gson.toJson(list);
	          
	          System.out.println(json);
	          */
	          ObjectMapper mapper=new ObjectMapper();
	          System.out.println(mapper.writeValueAsString(list));
	             return mapper.writeValueAsString(list);
	         }
	 @RequestMapping(value = "/addItemToCart", method = RequestMethod.GET)
		public @ResponseBody String addItemToCart(@RequestParam("pid")String drugid,@RequestParam("quantity")String quantity,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		Drug drug=drugDAO.findDrugById(Integer.parseInt(drugid));
		 HttpSession session=request.getSession();
		 int quant=Integer.parseInt(quantity);
		HashMap<String, String> map;
		List<HashMap> list;
		if(session.getAttribute("cart")==null){
			list=new ArrayList<HashMap>();
			map=new HashMap<String, String>();
			map.put("id", String.valueOf(drug.getId()));
			map.put("name", drug.getName());
			map.put("compound", drug.getCompound());
			map.put("quantity", quantity);
			list.add(map);
			
			session.setAttribute("cart", list);
		}else{
			list=(ArrayList<HashMap>)session.getAttribute("cart");
			boolean flag=true;
			for(HashMap<String,String> m:list)
			{
			if(String.valueOf(m.get("id")).equals(drugid))
			{
			flag=false;
			int q=Integer.parseInt(String.valueOf(m.get("quantity")));
			q=q+quant;
			m.put("quantity", String.valueOf(q));
			}
			}

			if(flag)
			{
			map=new HashMap<String, String>();
			map.put("id", String.valueOf(drug.getId()));
			map.put("name", drug.getName());
			map.put("compound", drug.getCompound());
			map.put("quantity", quantity);
			list.add(map);
			}
			session.setAttribute("cart", list);
		}
		 
		ObjectMapper mapper=new ObjectMapper();
        System.out.println(mapper.writeValueAsString(list));
           return mapper.writeValueAsString(list);
	 }
	 @RequestMapping(value = "/deleteItemToCart", method = RequestMethod.GET)
		public @ResponseBody String deleteItemToCart(@RequestParam("id")String drugid,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		 HashMap<String, String> tempMap=null;
			List<HashMap> list;
			HttpSession session=request.getSession();
			list=(ArrayList<HashMap>)session.getAttribute("cart");
			for(HashMap m:list){
				if(m.get("id").equals(drugid)){
					tempMap=m;
					break;
				}
			}
			list.remove(tempMap);
			session.setAttribute("cart", list);
			ObjectMapper mapper=new ObjectMapper();
	        System.out.println(mapper.writeValueAsString(list));
	           return mapper.writeValueAsString(list);
	 }
	 
	 
	 @RequestMapping(value = "/distributor_onorder", method = RequestMethod.POST)
		public String distributor_onorder(HttpServletRequest request, Model model) {
		 List<HashMap> list;
			HttpSession session=request.getSession();
			
			list=(ArrayList<HashMap>)session.getAttribute("cart");
			String apq=String.valueOf(list.get(0).get("id"));
			Drug drug=drugDAO.findDrugById(Integer.parseInt(apq));
			
			UserAccount receiver=(UserAccount)userAccountDAO.findUserAccountByEnterprise(drug.getManufacturer().getId());
			
			DrugOrder o=new DrugOrder();
			List<OrderItem> olist=new ArrayList<OrderItem>();
			for(HashMap m:list){
			 
			 Drug drug2=drugDAO.findDrugById(Integer.parseInt(String.valueOf(m.get("id"))));
			 OrderItem oi=new OrderItem();
			 oi.setDrug(drug2);
			 oi.setOrder(o);
			 oi.setQuantity(Integer.parseInt(String.valueOf(m.get("quantity"))));
			 olist.add(oi);
			}
			o.setOrderItems(olist);
			
		 
		
		
		 PurchaseOrderRequest por=new PurchaseOrderRequest();
			
			por.setOrder(o);
			por.setDateRequested(new Date().toString());
			por.setSender((UserAccount)session.getAttribute("user"));
			por.setReceiver(receiver);
			por.setStatus("Created");
			
			purchaseOrderRequestDAO.persist(por);
		
		//UserAccount ua2=userAccountDAO.findUserAccountById(1);
		//por.setReceiver(ua2);
		//purchaseOrderRequestDAO.update(por);
		
		 return "distributor_home";
	 }
	 
	 @RequestMapping(value = "/processManWR", method = RequestMethod.GET)
		public @ResponseBody String processManWR(@RequestParam("wid")String wrid,HttpServletRequest request, Model model) throws JsonGenerationException, JsonMappingException, IOException {
		 int wid=Integer.parseInt(wrid);
		 UserAccount ua=(UserAccount)request.getSession().getAttribute("user");
		 
		 PurchaseOrderRequest wr=purchaseOrderRequestDAO.findPurchaseOrderRequestById(wid);
		 if(!wr.getStatus().equals("Processed")){
		 List<OrderItem> olist=orderItemDAO.findOrderItemByOrder(wr.getOrder().getId());
		 for(OrderItem oi:olist){
			 for(int i=0;i<oi.getQuantity();i++){
				 
				 
				 Date expdate = new Date();  
				  
				 Calendar cal = Calendar.getInstance();  
				 cal.setTime(expdate);  
				 cal.add(Calendar.DATE, oi.getDrug().getLife()); // add 10 days  
				   
				 expdate = cal.getTime(); 
				 
				 
				 DrugPackage dp=new DrugPackage();
				 dp.setDrug(oi.getDrug());
				 dp.setOwner(ua);
				 dp.setStatus("Safe");
				 dp.setDateOfManufacuring(new Date());
				 dp.setDateOfExpiry(expdate);
				 dp.setDrugOrder(wr.getOrder());
				
				 
				 
				 PackageHistory ph=new PackageHistory();
				 ph.setDrugPackage(dp);
				 dp.setPackageHistory(ph);
				 
				 PackageTransaction pt=new PackageTransaction();
				 pt.setSender(ua);
				 pt.setReceiver(wr.getSender());
				 pt.setPackageHistory(ph);
				 packageTransactionDAO.persist(pt);
				
				
				
				 
			 }
		 }
		 
		 
		 ShippingRequest shr=new ShippingRequest();
		 shr.setDateRequested(new Date().toString());
		 shr.setOrder(wr.getOrder());
		 shr.setReceiver(wr.getSender());
		 shr.setSender(ua);
		 shr.setStatus("Created");
		 
		 shippingRequestDAO.persist(shr);
		 
		 wr.setStatus("Processed");
		 purchaseOrderRequestDAO.update(wr);
		 ObjectMapper mapper=new ObjectMapper();
	        System.out.println(mapper.writeValueAsString("Processed"));
	           return mapper.writeValueAsString("Processed");
	           
	 }
		 else{
			 ObjectMapper mapper=new ObjectMapper();
		        System.out.println(mapper.writeValueAsString("Already Processed"));
		           return mapper.writeValueAsString("Already Processed");
		 }
	 }
	 @RequestMapping(value = "/manufacturer_queue", method = RequestMethod.GET)
		public String manufacturer_queue(HttpServletRequest request, Model model) {
		 UserAccount ua=(UserAccount)request.getSession().getAttribute("user");
		 List <PurchaseOrderRequest> porList=new ArrayList<PurchaseOrderRequest>();
		 List<WorkRequest> list=workRequestDAO.findWorkRequestByReceiver(ua.getId());
		 for(WorkRequest wr:list){
			 
			 PurchaseOrderRequest por=purchaseOrderRequestDAO.findPurchaseOrderRequestById(wr.getId());
			 porList.add(por);
		 }
		 
		 model.addAttribute("queue", porList);
		 return "manufacturer_queue";
	 }
	 @RequestMapping(value = "/viewpordetails", method = RequestMethod.GET)
		public @ResponseBody String viewpordetails(@RequestParam("wid")String wrid,HttpServletRequest request, Model model) throws JsonGenerationException, JsonMappingException, IOException {
	 
		 PurchaseOrderRequest por=purchaseOrderRequestDAO.findPurchaseOrderRequestById(Integer.parseInt(wrid));
		 List<OrderItem> olist=orderItemDAO.findOrderItemByOrder(por.getOrder().getId());
		 List<HashMap<String, String>> list=new ArrayList<HashMap<String,String>>();
		 for(OrderItem oi:olist){
			 
			 HashMap<String, String> map=new HashMap<String, String>();
			 map.put("id", String.valueOf(oi.getId()));
			 map.put("name", oi.getDrug().getName());
			 map.put("compound", oi.getDrug().getCompound());
			 map.put("quantity", String.valueOf(oi.getQuantity()));
			 map.put("manufacturer", oi.getDrug().getManufacturer().getEnterpriseName());
			 list.add(map);
		 }
		 
		 ObjectMapper mapper=new ObjectMapper();
	        System.out.println(mapper.writeValueAsString(list));
	           return mapper.writeValueAsString(list);
	 }
	 
	 @RequestMapping(value = "/processDistSHR", method = RequestMethod.GET)
		public @ResponseBody String processDistSHR(@RequestParam("wid")String wrid,HttpServletRequest request, Model model) throws JsonGenerationException, JsonMappingException, IOException {
		 int wid=Integer.parseInt(wrid);
		 UserAccount ua=(UserAccount)request.getSession().getAttribute("user");
		 ShippingRequest shr=shippingRequestDAO.findShippingRequestById(wid);
		 if(!shr.getStatus().equals("Processed")){
		 int orderId=shr.getOrder().getId();
		 List <DrugPackage> orderedList=drugPackageDAO.findDrugPackageByOrder(orderId);
		 
		 for(DrugPackage dp:orderedList){
			 dp.setOwner(ua);
			 dp.setDrugOrder(drugOrderDAO.findOrderById(1));
			 drugPackageDAO.update(dp);
		 }
		 shr.setStatus("Processed");
		 shippingRequestDAO.update(shr);
		 ObjectMapper mapper=new ObjectMapper();
	        System.out.println(mapper.writeValueAsString("Processed"));
	           return mapper.writeValueAsString("Processed"); 
	 }else{
		 ObjectMapper mapper=new ObjectMapper();
	        System.out.println(mapper.writeValueAsString("Already Processed"));
	           return mapper.writeValueAsString("Already Processed");
	 }
	
	 }
	 @RequestMapping(value = "/distributor_shippingqueue", method = RequestMethod.GET)
		public String distributor_shippingqueue(HttpServletRequest request, Model model) {
		 UserAccount usa=(UserAccount)request.getSession().getAttribute("user");
		 List <ShippingRequest> shrList=new ArrayList<ShippingRequest>();
		 List<WorkRequest> list=workRequestDAO.findWorkRequestByReceiver(usa.getId());
		 for(WorkRequest wr:list){
			 
			 ShippingRequest shr=shippingRequestDAO.findShippingRequestById(wr.getId());
			if(shr!=null)
			 shrList.add(shr);
		 }
		 
		 model.addAttribute("queue", shrList);
		 
		 
		 return "distributor_shippingqueue";
	 }
	 
	 @RequestMapping(value = "/distributor_inventory", method = RequestMethod.GET)
		public String distributor_inventory(HttpServletRequest request, Model model) {
	UserAccount usa=(UserAccount)request.getSession().getAttribute("user");
	List<DrugPackage> list=drugPackageDAO.findDrugPackageByOwner(usa.getId());
	HashMap<Drug, Integer> map=new HashMap<Drug, Integer>();
	
	for(DrugPackage dp:list){
		if(dp.getStatus().equals("Safe")){
		if(map.containsKey(dp.getDrug())){
			int x=map.get(dp.getDrug());
			map.put(dp.getDrug(), x+1);
		}else{
			map.put(dp.getDrug(), 1);
		}
	}
	}
		 model.addAttribute("map",map);
		 return "distributor_inventory";
	 }
	 
	 
	 @RequestMapping(value = "/inventoryPackageByDrug", method = RequestMethod.GET)
		public @ResponseBody String inventoryPackageByDrug(@RequestParam("pid")String drugid,HttpServletRequest request, Model model) throws JsonGenerationException, JsonMappingException, IOException {
		 UserAccount usa=(UserAccount)request.getSession().getAttribute("user");
		 int drid=Integer.parseInt(drugid);
		 List<DrugPackage> flist=drugPackageDAO.findDrugPackageByOwner(usa.getId());
		 List<DrugPackage> list=new ArrayList<DrugPackage>();
		 for(DrugPackage dp:flist){
			 if(dp.getDrug().getId()==drid&&dp.getStatus().equals("Safe")){
				 
				 list.add(dp);
			 }
		 }
		 
		 ObjectMapper mapper=new ObjectMapper();
	        System.out.println(mapper.writeValueAsString(list));
	           return mapper.writeValueAsString(list);
	 }
	 
	 @RequestMapping(value = "/reportPackage", method = RequestMethod.GET)
		public @ResponseBody String reportPackage(@RequestParam("id")String packid,HttpServletRequest request, Model model) throws JsonGenerationException, JsonMappingException, IOException {
		 UserAccount usa=(UserAccount)request.getSession().getAttribute("user");
		 int pkid=Integer.parseInt(packid);
		 DrugPackage reporteddp=drugPackageDAO.findDrugPackageById(pkid);
		 reporteddp.setStatus("Suspected");
		 drugPackageDAO.update(reporteddp);
		 ///////
		 List<DrugPackage> flist=drugPackageDAO.findDrugPackageByOwner(usa.getId());
		 List<DrugPackage> list=new ArrayList<DrugPackage>();
		 for(DrugPackage dp:flist){
			 if(dp.getDrug().getId()==reporteddp.getDrug().getId()&&dp.getStatus().equals("Safe")){
				 list.add(dp);
			 }
		 }
		 ObjectMapper mapper=new ObjectMapper();
	        System.out.println(mapper.writeValueAsString(list));
	           return mapper.writeValueAsString(list);
		 
	 }
	 
	 @RequestMapping(value = "/patient_onorder", method = RequestMethod.POST)
		public String patient_onorder(HttpServletRequest request, Model model) {
		 List<HashMap> list;
			HttpSession session=request.getSession();
			
			list=(ArrayList<HashMap>)session.getAttribute("cart");
			
			
			int hosid=Integer.parseInt(request.getParameter("selecthospital"));
			UserAccount receiver=(UserAccount)userAccountDAO.findUserAccountByEnterprise(hosid);
			
			DrugOrder o=new DrugOrder();
			List<OrderItem> olist=new ArrayList<OrderItem>();
			for(HashMap m:list){
			 
			 Drug drug2=drugDAO.findDrugById(Integer.parseInt(String.valueOf(m.get("id"))));
			 OrderItem oi=new OrderItem();
			 oi.setDrug(drug2);
			 oi.setOrder(o);
			 oi.setQuantity(Integer.parseInt(String.valueOf(m.get("quantity"))));
			 olist.add(oi);
			}
			o.setOrderItems(olist);
			
		 
		
		
		 PurchaseOrderRequest por=new PurchaseOrderRequest();
			
			por.setOrder(o);
			por.setDateRequested(new Date().toString());
			por.setSender((UserAccount)session.getAttribute("user"));
			por.setReceiver(receiver);
			por.setStatus("Created");
			
			purchaseOrderRequestDAO.persist(por);
		
		//UserAccount ua2=userAccountDAO.findUserAccountById(1);
		//por.setReceiver(ua2);
		//purchaseOrderRequestDAO.update(por);
		
		 return "patient_home";
	 }
	 @RequestMapping(value = "/hospital_shippingqueue", method = RequestMethod.GET)
		public String hospital_shippingqueue(HttpServletRequest request, Model model) {
		 UserAccount usa=(UserAccount)request.getSession().getAttribute("user");
		 List <ShippingRequest> shrList=new ArrayList<ShippingRequest>();
		 List<WorkRequest> list=workRequestDAO.findWorkRequestByReceiver(usa.getId());
		 for(WorkRequest wr:list){
			 
			 ShippingRequest shr=shippingRequestDAO.findShippingRequestById(wr.getId());
			 if(shr!=null)
			 shrList.add(shr);
		 }
		 
		 model.addAttribute("queue", shrList);
		 
		 
		 return "hospital_shippingqueue";
	 }
	 
	 @RequestMapping(value = "/hospital_inventory", method = RequestMethod.GET)
		public String hospital_inventory(HttpServletRequest request, Model model) {
	UserAccount usa=(UserAccount)request.getSession().getAttribute("user");
	List<DrugPackage> list=drugPackageDAO.findDrugPackageByOwner(usa.getId());
	HashMap<Drug, Integer> map=new HashMap<Drug, Integer>();
	
	for(DrugPackage dp:list){
		if(dp.getStatus().equals("Safe")){
		if(map.containsKey(dp.getDrug())){
			int x=map.get(dp.getDrug());
			map.put(dp.getDrug(), x+1);
		}else{
			map.put(dp.getDrug(), 1);
		}
	}
	}
		 model.addAttribute("map",map);
		 return "hospital_inventory";
	 }
	 
	 @RequestMapping(value = "/hospital_home", method = RequestMethod.GET)
		public String hospital_home(HttpServletRequest request, Model model) {
		
		 return "hospital_home";
	 }
	 @RequestMapping(value = "/hospital_order", method = RequestMethod.GET)
		public String hospital_order(HttpServletRequest request, Model model) {
		
		 
		 request.getSession().setAttribute("cart", null);
			
		 List<Enterprise> list=enterpriseDAO.findEnterpriseListByType("Distributor");
		 
         List<Drug> list1=drugDAO.findAllDrugs();
		 
         model.addAttribute("list1",list1);
         model.addAttribute("list",list);
		 return "hospital_order";
	 }
	 
	 @RequestMapping(value = "/processWR", method = RequestMethod.GET)
		public @ResponseBody String processWR(@RequestParam("wid")String wrid,HttpServletRequest request, Model model) throws JsonGenerationException, JsonMappingException, IOException {
		 int wid=Integer.parseInt(wrid);
		 UserAccount ua=(UserAccount)request.getSession().getAttribute("user");
		 HashMap<String, Integer> map=new HashMap<String, Integer>();
		 List<DrugPackage> inventoryList=drugPackageDAO.findDrugPackageByOwner(ua.getId());
		 String alert="";
		 for(DrugPackage dp:inventoryList){
				if(dp.getStatus().equals("Safe")){
				if(map.containsKey(String.valueOf(dp.getDrug().getId()))){
					int x=map.get(String.valueOf(dp.getDrug().getId()));
					map.put(String.valueOf(dp.getDrug().getId()), x+1);
				}else{
					map.put(String.valueOf(dp.getDrug().getId()), 1);
				}
			}
			}
		 
		 PurchaseOrderRequest wr=purchaseOrderRequestDAO.findPurchaseOrderRequestById(wid);
		 if(!wr.getStatus().equals("Processed")){
			 List<OrderItem> olist=orderItemDAO.findOrderItemByOrder(wr.getOrder().getId());
			 for(OrderItem oi:olist){
				 if(map.containsKey(String.valueOf(oi.getDrug().getId()))){
					 if(map.get(String.valueOf(oi.getDrug().getId()))>=oi.getQuantity()){
						 
						 
					 }else{
						alert= "Insufficient inventory";
						break;
					 }
				 }else{
					alert= "Unavailable in inventory";
					break;
				 }
				 
			 }
			 
			 
		 if(alert.isEmpty()){
			 for(OrderItem oi:olist){
				 int nop=oi.getQuantity();
			 for(int i=0;i<oi.getQuantity();i++){
				 for(DrugPackage dp:inventoryList){
					 if(dp.getDrug().getId()==oi.getDrug().getId()){
						if(nop>0){
						 dp.setDrugOrder(wr.getOrder());
						 PackageTransaction pt=new PackageTransaction();
						 pt.setPackageHistory(dp.getPackageHistory());
						 pt.setSender(ua);
						 pt.setReceiver(wr.getSender());
						 packageTransactionDAO.persist(pt);
						 drugPackageDAO.update(dp);
						nop--;
						}
					 }
				 }
			 }
			 }
			 ShippingRequest shr=new ShippingRequest();
			 shr.setDateRequested(new Date().toString());
			 shr.setOrder(wr.getOrder());
			 shr.setReceiver(wr.getSender());
			 shr.setSender(ua);
			 shr.setStatus("Created");
			 
			 shippingRequestDAO.persist(shr);
			 wr.setStatus("Processed");
			 purchaseOrderRequestDAO.update(wr);
			 alert="Processed";
			 }
		 
		 }else{
			 alert="Already Processed";
		 }
		 ObjectMapper mapper=new ObjectMapper();
	     System.out.println(mapper.writeValueAsString(alert));
	        return mapper.writeValueAsString(alert);
	 }
	
	 
	 @RequestMapping(value = "/distributor_purchasequeue", method = RequestMethod.GET)
		public String distributor_purchasequeue(HttpServletRequest request, Model model) {
		 UserAccount ua=(UserAccount)request.getSession().getAttribute("user");
		 List <PurchaseOrderRequest> porList=new ArrayList<PurchaseOrderRequest>();
		 List<WorkRequest> list=workRequestDAO.findWorkRequestByReceiver(ua.getId());
		 for(WorkRequest wr:list){
			 
			 PurchaseOrderRequest por=purchaseOrderRequestDAO.findPurchaseOrderRequestById(wr.getId());
			if(por!=null)
			porList.add(por);
		 }
		 
		 model.addAttribute("queue", porList);
		 return "distributor_purchasequeue";
	 }
	 @RequestMapping(value = "/hospital_purchasequeue", method = RequestMethod.GET)
		public String hospital_purchasequeue(HttpServletRequest request, Model model) {
		 UserAccount ua=(UserAccount)request.getSession().getAttribute("user");
		 List <PurchaseOrderRequest> porList=new ArrayList<PurchaseOrderRequest>();
		 List<WorkRequest> list=workRequestDAO.findWorkRequestByReceiver(ua.getId());
		 for(WorkRequest wr:list){
			 
			 PurchaseOrderRequest por=purchaseOrderRequestDAO.findPurchaseOrderRequestById(wr.getId());
			if(por!=null)
			porList.add(por);
		 }
		 
		 model.addAttribute("queue", porList);
		 return "hospital_purchasequeue";
	 }
	 @RequestMapping(value = "/patient_home", method = RequestMethod.GET)
		public String patient_home(HttpServletRequest request, Model model) {
		
		 return "patient_home";
	 }
	 @RequestMapping(value = "/patient_order", method = RequestMethod.GET)
		public String patient_order(HttpServletRequest request, Model model) {
		
		 
		 request.getSession().setAttribute("cart", null);
			
		 List<Enterprise> list=enterpriseDAO.findEnterpriseListByType("Hospital");
		 
      List<Drug> list1=drugDAO.findAllDrugs();
		 
      model.addAttribute("list1",list1);
      model.addAttribute("list",list);
		 return "patient_order";
	 }
	 @RequestMapping(value = "/patient_shippingqueue", method = RequestMethod.GET)
		public String patient_shippingqueue(HttpServletRequest request, Model model) {
		 UserAccount usa=(UserAccount)request.getSession().getAttribute("user");
		 List <ShippingRequest> shrList=new ArrayList<ShippingRequest>();
		 List<WorkRequest> list=workRequestDAO.findWorkRequestByReceiver(usa.getId());
		 for(WorkRequest wr:list){
			 
			 ShippingRequest shr=shippingRequestDAO.findShippingRequestById(wr.getId());
			 if(shr!=null)
			 shrList.add(shr);
		 }
		 
		 model.addAttribute("queue", shrList);
		 
		 
		 return "patient_shippingqueue";
	 }
	 
	 @RequestMapping(value = "/patient_inventory", method = RequestMethod.GET)
		public String patient_inventory(HttpServletRequest request, Model model) {
	UserAccount usa=(UserAccount)request.getSession().getAttribute("user");
	List<DrugPackage> list=drugPackageDAO.findDrugPackageByOwner(usa.getId());
	HashMap<Drug, Integer> map=new HashMap<Drug, Integer>();
	
	for(DrugPackage dp:list){
		if(dp.getStatus().equals("Safe")){
		if(map.containsKey(dp.getDrug())){
			int x=map.get(dp.getDrug());
			map.put(dp.getDrug(), x+1);
		}else{
			map.put(dp.getDrug(), 1);
		}
	}
	}
		 model.addAttribute("map",map);
		 return "patient_inventory";
	 }
	 
	 @RequestMapping(value = "/hospital_onorder", method = RequestMethod.POST)
		public String hospital_onorder(HttpServletRequest request, Model model) {
		 List<HashMap> list;
			HttpSession session=request.getSession();
			
			list=(ArrayList<HashMap>)session.getAttribute("cart");
			
			
			int distid=Integer.parseInt(request.getParameter("selectdistributor"));
			UserAccount receiver=(UserAccount)userAccountDAO.findUserAccountByEnterprise(distid);
			
			DrugOrder o=new DrugOrder();
			List<OrderItem> olist=new ArrayList<OrderItem>();
			for(HashMap m:list){
			 
			 Drug drug2=drugDAO.findDrugById(Integer.parseInt(String.valueOf(m.get("id"))));
			 OrderItem oi=new OrderItem();
			 oi.setDrug(drug2);
			 oi.setOrder(o);
			 oi.setQuantity(Integer.parseInt(String.valueOf(m.get("quantity"))));
			 olist.add(oi);
			}
			o.setOrderItems(olist);
		
			PurchaseOrderRequest por=new PurchaseOrderRequest();
			
			por.setOrder(o);
			por.setDateRequested(new Date().toString());
			por.setSender((UserAccount)session.getAttribute("user"));
			por.setReceiver(receiver);
			por.setStatus("Created");
			
			purchaseOrderRequestDAO.persist(por);
		
		//UserAccount ua2=userAccountDAO.findUserAccountById(1);
		//por.setReceiver(ua2);
		//purchaseOrderRequestDAO.update(por);
		
		 return "hospital_home";
	 }

	 @RequestMapping(value = "/fda_home", method = RequestMethod.GET)
		public String fda_home(HttpServletRequest request, Model model) {
		 
		 return "fda_home";
	 }
	 @RequestMapping(value = "/fda_reports", method = RequestMethod.GET)
		public String fda_reports(HttpServletRequest request, Model model) {
		 
		 List<DrugPackage> suspectedList=drugPackageDAO.findSuspectedDrugPackages();
		 model.addAttribute("list", suspectedList);
		 
		 return "fda_reports";
	 }
	 @RequestMapping(value = "/fda_revoke", method = RequestMethod.GET)
		public String fda_revoke(HttpServletRequest request, Model model) {
		 
		 List<DrugPackage> suspectedList=drugPackageDAO.findConfisticatedDrugPackages();
		 List<DrugPackage> counterList=drugPackageDAO.findCoounterfeitDrugPackages();
		 for(DrugPackage dp:counterList)
			 suspectedList.add(dp);
		 
		 
		 model.addAttribute("list", suspectedList);
		 
		
		 
		 return "fda_revoke";
	 }
	 
	 @RequestMapping(value = "/confisticatePackage", method = RequestMethod.GET)
		public @ResponseBody String confisticatePackage(@RequestParam("pid")String pid,HttpServletRequest request, Model model) throws JsonGenerationException, JsonMappingException, IOException {
		 DrugPackage dp=drugPackageDAO.findDrugPackageById(Integer.parseInt(pid));
		 UserAccount ua=(UserAccount)request.getSession().getAttribute("user");
		 
		 dp.setStatus("Confisticated");
		 dp.setOwner(ua);
		 drugPackageDAO.update(dp);
		 List<DrugPackage> suspectedList=drugPackageDAO.findSuspectedDrugPackages();
		 
		 ObjectMapper mapper=new ObjectMapper();
	        System.out.println(mapper.writeValueAsString(suspectedList));
	           return mapper.writeValueAsString(suspectedList);
		 
	 }
	 @RequestMapping(value = "/testPackage", method = RequestMethod.GET)
		public @ResponseBody String testPackage(@RequestParam("pid")String pid,HttpServletRequest request, Model model) throws JsonGenerationException, JsonMappingException, IOException {
		 String alert="";
		 DrugPackage dp=drugPackageDAO.findDrugPackageById(Integer.parseInt(pid));
		 List<PackageTransaction> transList=packageTransactionDAO.findPackageTransactionByPackageHistory(dp.getPackageHistory().getId());
		 if(transList.size()<=1){
			 if(transList.size()!=1||dp.getDrug().getManufacturer().getId()!=transList.get(0).getSender().getEnterprise().getId())
			 { dp.setStatus("Counterfeit");
			 drugPackageDAO.update(dp);
				 alert="Counterfeit";
			 }
		 }else{
			 for(int i=1;i<transList.size();i++){
				 if(transList.get(i).getReceiver().getId()!=transList.get(i-1).getSender().getId())
				 {
					 dp.setStatus("Counterfeit");
					 drugPackageDAO.update(dp);
					 alert="Counterfeit";
				 	break;
				 }
			 }
		 }
		 if(alert.isEmpty()){
			 dp.setStatus("Safe");
		 drugPackageDAO.update(dp);
			 alert="Safe";
		 }
		 ObjectMapper mapper=new ObjectMapper();
	        System.out.println(mapper.writeValueAsString(alert));
	           return mapper.writeValueAsString(alert);
	 }
	 
	 
	 @RequestMapping(value = "/revoke", method = RequestMethod.GET)
		public @ResponseBody String revoke(@RequestParam("pid")String pid,HttpServletRequest request, Model model) throws JsonGenerationException, JsonMappingException, IOException {
		 DrugPackage dp=drugPackageDAO.findDrugPackageById(Integer.parseInt(pid));
		 UserAccount ua=(UserAccount)request.getSession().getAttribute("user");
	if(dp.getDrug().getStatus().equals("Licensed"))	 
	{
		 dp.getDrug().setStatus("Deprecated");
		 drugDAO.update(dp.getDrug());
		 List<DrugPackage> pList=drugPackageDAO.findDrugPackageByDrug(dp.getDrug().getId());
		 for(DrugPackage pack:pList)
		 {
			 pack.setStatus("Counterfeit");
			 pack.setOwner(ua);
			 drugPackageDAO.update(pack);
		 }
		 ObjectMapper mapper=new ObjectMapper();
		 return mapper.writeValueAsString("Done!!!");
	}else{
		ObjectMapper mapper=new ObjectMapper();
		 return mapper.writeValueAsString("Already Done!");
	}
	 }
	 
	 @RequestMapping(value = "/disposeDrugs", method = RequestMethod.POST)
		public String disposeDrugs(HttpServletRequest request, Model model) {
	
		 List<DrugPackage> confList=drugPackageDAO.findConfisticatedDrugPackages();
		 List<DrugPackage> counList=drugPackageDAO.findCoounterfeitDrugPackages();
		 for(DrugPackage dp1:counList){
			 confList.add(dp1);
		 }
		 for(DrugPackage dp:confList){
			 List<PackageTransaction> tranList=packageTransactionDAO.findPackageTransactionByPackageHistory(dp.getPackageHistory().getId());
			 for(PackageTransaction pt:tranList){
				 packageTransactionDAO.removeTransaction(pt.getId());
			 }
			 packageHistoryDAO.removeHistory(dp.getPackageHistory().getId());
			 drugPackageDAO.removePackage(dp.getId());
		 }
		 
		 return "fda_home";
	 }
	 }
