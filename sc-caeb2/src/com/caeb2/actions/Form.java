package com.caeb2.actions;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.database.LoadDataBase;
import com.caeb2.database.SaveDataBase;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.Controller.PropFileRole;
import com.caeb2.util.TextUtils;

public class Form {

	public static void saveProcessPage1(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Controller.getLogger().info("+ saveProcessPage1");

		PropertiesConfiguration prop = Controller.getPropertiesFile( //
				Constants.PROP_FILE_DWELLING, PropFileRole.LOAD, request.getRequestedSessionId());

		String street = request.getParameter(Constants.SECTION1_STREET);
		String name_housing = request.getParameter(Constants.SECTION1_NAME_HOUSING);
		String home_phone = request.getParameter(Constants.SECTION1_HOME_PHONE);

		prop.setProperty(Constants.SECTION1_STREET, street);
		prop.setProperty(Constants.SECTION1_NAME_HOUSING, name_housing);
		prop.setProperty(Constants.SECTION1_HOME_PHONE, home_phone);

		prop.save();

		Controller.getLogger().info("- saveProcessPage1");

		PollManager.setCurrentPage(request, 2);

		Controller.forward(request, response, "page_2.jsp");

	}

	public static void saveProcessPage2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Controller.getLogger().info("+ saveProcessPage2");

		PropertiesConfiguration prop = Controller.getPropertiesFile( //
				Constants.PROP_FILE_DWELLING, PropFileRole.LOAD, request.getRequestedSessionId());

		String structure_type=TextUtils.escaparString(request.getParameter(Constants.SECTION2_STRUCTURE_TYPE));
		String holding=TextUtils.escaparString(request.getParameter(Constants.SECTION2_HOLDING));
		String total_rooms=TextUtils.escaparString(request.getParameter(Constants.SECTION2_TOTAL_ROOMS));
		String housing_fits_household=TextUtils.escaparString(request.getParameter(Constants.SECTION2_HOUSING_FITS_HOUSEHOLD));
		String house_sector=TextUtils.escaparString(request.getParameter(Constants.SECTION2_HOUSE_SECTOR));
		String house_scalability=TextUtils.escaparString(request.getParameter(Constants.SECTION2_HOUSE_SCALABILITY));
		String walls_type=TextUtils.escaparString(request.getParameter(Constants.SECTION2_WALLS_TYPE));
		String ceiling_type=TextUtils.escaparString(request.getParameter(Constants.SECTION2_CEILING_TYPE));
		String flat_type=TextUtils.escaparString(request.getParameter(Constants.SECTION2_FLAT_TYPE));
		String location_kitchen=TextUtils.escaparString(request.getParameter(Constants.SECTION2_LOCATION_KITCHEN));
		String housing_water=TextUtils.escaparString(request.getParameter(Constants.SECTION2_HOUSING_WATER));
		String other_housing_water=TextUtils.escaparString(request.getParameter(Constants.SECTION2_OTHER_HOUSING_WATER)); 
		String sanitary_service=TextUtils.escaparString(request.getParameter(Constants.SECTION2_SANITARY_SERVICE));
		String electrical_service=TextUtils.escaparString(request.getParameter(Constants.SECTION2_ELECTRICAL_SERVICE));
		String garbage_collection=TextUtils.escaparString(request.getParameter(Constants.SECTION2_GARBAGE_COLLECTION));
		String housing_risk=TextUtils.escaparString(request.getParameter(Constants.SECTION2_HOUSING_RISK));
		String urgent_housing_improvements=TextUtils.escaparString(request.getParameter(Constants.SECTION2_URGENT_HOUSING_IMPROVEMENTS));

		String part[]=TextUtils.escaparArray(request.getParameterValues(Constants.SECTION2_PART));
		String required[]=TextUtils.escaparArray(request.getParameterValues(Constants.SECTION2_REQUIRED));
		String workNeeds[]=TextUtils.escaparArray(request.getParameterValues(Constants.SECTION2_WORK_NEEDS));

		String part_other_response=TextUtils.escaparString(request.getParameter(Constants.SECTION2_PART_OTHER_RESPONSE));
		String required_other_response=TextUtils.escaparString(request.getParameter(Constants.SECTION2_REQUIRED_OTHER_RESPONSE));
		String work_needs_other_response=TextUtils.escaparString(request.getParameter(Constants.SECTION2_WORK_NEEDS_OTHER_RESPONSE));

		prop.setProperty(Constants.SECTION2_STRUCTURE_TYPE,structure_type);
		prop.setProperty(Constants.SECTION2_HOLDING,holding);
		prop.setProperty(Constants.SECTION2_TOTAL_ROOMS,total_rooms);
		prop.setProperty(Constants.SECTION2_HOUSING_FITS_HOUSEHOLD,housing_fits_household);
		prop.setProperty(Constants.SECTION2_HOUSE_SECTOR,house_sector);
		prop.setProperty(Constants.SECTION2_HOUSE_SCALABILITY,house_scalability);
		prop.setProperty(Constants.SECTION2_WALLS_TYPE,walls_type);
		prop.setProperty(Constants.SECTION2_CEILING_TYPE,ceiling_type);
		prop.setProperty(Constants.SECTION2_FLAT_TYPE,flat_type);
		prop.setProperty(Constants.SECTION2_LOCATION_KITCHEN,location_kitchen);
		prop.setProperty(Constants.SECTION2_HOUSING_WATER,housing_water);
		prop.setProperty(Constants.SECTION2_OTHER_HOUSING_WATER,other_housing_water); 
		prop.setProperty(Constants.SECTION2_SANITARY_SERVICE,sanitary_service);
		prop.setProperty(Constants.SECTION2_ELECTRICAL_SERVICE,electrical_service);
		prop.setProperty(Constants.SECTION2_GARBAGE_COLLECTION,garbage_collection);
		prop.setProperty(Constants.SECTION2_HOUSING_RISK,housing_risk);
		prop.setProperty(Constants.SECTION2_URGENT_HOUSING_IMPROVEMENTS,urgent_housing_improvements);

		prop.setProperty(Constants.SECTION2_PART,part);
		prop.setProperty(Constants.SECTION2_REQUIRED,required);
		prop.setProperty(Constants.SECTION2_WORK_NEEDS,workNeeds);

		prop.setProperty(Constants.SECTION2_PART_OTHER_RESPONSE,part_other_response);
		prop.setProperty(Constants.SECTION2_REQUIRED_OTHER_RESPONSE,required_other_response);
		prop.setProperty(Constants.SECTION2_WORK_NEEDS_OTHER_RESPONSE,work_needs_other_response);

		prop.save();

		Controller.getLogger().info("- saveProcessPage2");

		PollManager.setCurrentPage(request, 3);

		Controller.forward(request, response, "page_3.jsp");

	}

	public static void saveProcessPage3(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Controller.getLogger().info("+ saveProcessPage3");

		String observations = TextUtils.escaparString(request.getParameter(Constants.SECTION3_OBSERVATIONS));

		PropertiesConfiguration prop = null;

		try {
			prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, //
					PropFileRole.SAVE, request.getRequestedSessionId());
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.SEVERE, Constants.LOAD_PROP_ERROR, e);
			Controller.forward(request, response, "error.jsp", Constants.LOAD_DATA_ERROR);
			return;
		}

		prop.setProperty(Constants.SECTION3_OBSERVATIONS, observations);
		prop.setProperty(Constants.SECTION3_USER, request.getSession(false).getAttribute(Constants.ATT_USER));

		prop.save();
		
		Long v=SaveDataBase.updateDwelling(new Long(1), request.getRequestedSessionId());

		if (v != null) {
			PollManager.cleanPropFile(Constants.PROP_FILE_DWELLING, request.getRequestedSessionId());
		}

		Controller.getLogger().info("- saveProcessPage3");

		PollManager.setCurrentPage(request, 4);

		Controller.forward(request, response, "page_4.jsp");

	}

	public static void saveProcessPage4(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Controller.getLogger().info("+ saveProcessPage4");

		PropertiesConfiguration prop = Controller.getPropertiesFile(Constants.PROP_FILE_HOME, //
				PropFileRole.LOAD, request.getRequestedSessionId());

		//		String section4_home=TextUtils.escaparString(request.getParameter(Constants.SECTION4_HOME));
		//		String section4_to=TextUtils.escaparString(request.getParameter(Constants.SECTION4_TO));
		String section4_rooms=TextUtils.escaparString(request.getParameter(Constants.SECTION4_ROOMS));
		String section4_chief_couple=TextUtils.escaparString(request.getParameter(Constants.SECTION4_CHIEF_COUPLE));
		String section4_used_mercal=TextUtils.escaparString(request.getParameter(Constants.SECTION4_USED_MERCAL));
		String section4_used_mercal_selected=TextUtils.escaparString(request.getParameter(Constants.SECTION4_USED_MERCAL_SELECTED));
		String section4_food_markets=TextUtils.escaparString(request.getParameter(Constants.SECTION4_FOOD_MARKETS));
		String section4_food_markets_response=TextUtils.escaparString(request.getParameter(Constants.SECTION4_FOOD_MARKETS_RESPONSE));
		String section4_number_bathrooms=TextUtils.escaparString(request.getParameter(Constants.SECTION4_NUMBER_BATHROOMS));
		//		String section4_total_persons=TextUtils.escaparString(request.getParameter(Constants.SECTION4_TOTAL_PERSONS));
		String section4_sleeps_3_or_more=TextUtils.escaparString(request.getParameter(Constants.SECTION4_SLEEPS_3_OR_MORE));
		String section4_used_pdval=TextUtils.escaparString(request.getParameter(Constants.SECTION4_USED_PDVAL));
		String section4_used_pdval_selected=TextUtils.escaparString(request.getParameter(Constants.SECTION4_USED_PDVALL_SELECTED));
		String section4_community_organization=TextUtils.escaparString(request.getParameter(Constants.SECTION4_COMMUNITY_ORGANIZATIO));
		String section4_community_organization_which=TextUtils.escaparString(request.getParameter(Constants.SECTION4_COMMUNITY_ORGANIZATION_WHICH));
		String section4_community_problems_other=TextUtils.escaparString(request.getParameter(Constants.SECTION4_COMMUNITY_PROBLEMS_OTHER));

		String section4_community_problems[]=TextUtils.escaparArray(request.getParameterValues(Constants.SECTION4_COMMUNITY_PROBLEMS));

		//		prop.setProperty(Constants.SECTION4_HOME,section4_home);
		//		prop.setProperty(Constants.SECTION4_TO,section4_to);
		prop.setProperty(Constants.SECTION4_ROOMS,section4_rooms);
		prop.setProperty(Constants.SECTION4_CHIEF_COUPLE,section4_chief_couple);
		prop.setProperty(Constants.SECTION4_USED_MERCAL,section4_used_mercal);
		prop.setProperty(Constants.SECTION4_USED_MERCAL_SELECTED,section4_used_mercal_selected);
		prop.setProperty(Constants.SECTION4_FOOD_MARKETS,section4_food_markets);
		prop.setProperty(Constants.SECTION4_FOOD_MARKETS_RESPONSE,section4_food_markets_response);
		prop.setProperty(Constants.SECTION4_NUMBER_BATHROOMS,section4_number_bathrooms);
		//		prop.setProperty(Constants.SECTION4_TOTAL_PERSONS,section4_total_persons);
		prop.setProperty(Constants.SECTION4_SLEEPS_3_OR_MORE,section4_sleeps_3_or_more);
		prop.setProperty(Constants.SECTION4_USED_PDVAL,section4_used_pdval);
		prop.setProperty(Constants.SECTION4_USED_PDVALL_SELECTED,section4_used_pdval_selected);
		prop.setProperty(Constants.SECTION4_COMMUNITY_ORGANIZATIO,section4_community_organization);
		prop.setProperty(Constants.SECTION4_COMMUNITY_ORGANIZATION_WHICH,section4_community_organization_which);
		prop.setProperty(Constants.SECTION4_COMMUNITY_PROBLEMS,section4_community_problems);
		prop.setProperty(Constants.SECTION4_COMMUNITY_PROBLEMS_OTHER,section4_community_problems_other);

		prop.save();

		Controller.getLogger().info("- saveProcessPage4");

		PollManager.setCurrentPage(request, 5);
		Long v=SaveDataBase.updateHome(new Long(1), request.getRequestedSessionId());
		if(v!=null){
			PollManager.cleanPropFile(Constants.PROP_FILE_HOME, request.getRequestedSessionId());
		}
		
		System.out.println("----------------------------------------------");
		LoadDataBase.loadHome(1, request.getRequestedSessionId());
//		LoadDataBase.loadPerson(1);

		Controller.forward(request, response, "page_5.jsp");

	}

	public static void saveProcessPage7(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Controller.getLogger().info("+ saveProcessPage7");

		PropertiesConfiguration prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, //
				PropFileRole.LOAD, request.getRequestedSessionId());

		String degree_approved_text=TextUtils.escaparString(request.getParameter(Constants.SECTION7_DEGREE_APPROVED_LEVEL));
		String degree_approved_level=TextUtils.escaparString(request.getParameter(Constants.SECTION7_DEGREE_APPROVED_TEXT));
		String you_are=TextUtils.escaparString(request.getParameter(Constants.SECTION7_YOU_ARE));
		String occupation=TextUtils.escaparString(request.getParameter(Constants.SECTION7_OCCUPATION));
		String occupation_value=TextUtils.escaparString(request.getParameter(Constants.SECTION7_OCCUPATION_VALUE));
		String work_performed=TextUtils.escaparString(request.getParameter(Constants.SECTION7_WORK_PERFORMED));
		String skills_activity=TextUtils.escaparString(request.getParameter(Constants.SECTION7_SKILLS_ACTIVITY));
		String skills_activity_option=TextUtils.escaparString(request.getParameter(Constants.SECTION7_SKILLS_ACTIVITY_OPTION));

		String profession=TextUtils.escaparString(request.getParameter(Constants.SECTION7_PROFESSION));
		String main_job=TextUtils.escaparString(request.getParameter(Constants.SECTION7_MAIN_JOB));
		String body_works=TextUtils.escaparString(request.getParameter(Constants.SECTION7_BODY_WORKS));
		String monthly_income=TextUtils.escaparString(request.getParameter(Constants.SECTION7_MONTHLY_INCOME));
		String received_credit=TextUtils.escaparString(request.getParameter(Constants.SECTION7_RECEIVED_CREDIT));
		String received_credit_value=TextUtils.escaparString(request.getParameter(Constants.SECTION7_RECEIVED_CREDIT_VALUE));
		String received_credit_value_other=TextUtils.escaparString(request.getParameter(Constants.SECTION7_RECEIVED_CREDIT_VALUE_OTHER));

		prop.setProperty(Constants.SECTION7_DEGREE_APPROVED_LEVEL,degree_approved_text);
		prop.setProperty(Constants.SECTION7_DEGREE_APPROVED_TEXT,degree_approved_level);
		prop.setProperty(Constants.SECTION7_YOU_ARE,you_are);
		prop.setProperty(Constants.SECTION7_OCCUPATION,occupation);
		prop.setProperty(Constants.SECTION7_OCCUPATION_VALUE,occupation_value);
		prop.setProperty(Constants.SECTION7_WORK_PERFORMED,work_performed);
		prop.setProperty(Constants.SECTION7_SKILLS_ACTIVITY,skills_activity);
		prop.setProperty(Constants.SECTION7_SKILLS_ACTIVITY_OPTION,skills_activity_option);

		prop.setProperty(Constants.SECTION7_PROFESSION,profession);
		prop.setProperty(Constants.SECTION7_MAIN_JOB,main_job);
		prop.setProperty(Constants.SECTION7_BODY_WORKS,body_works);
		prop.setProperty(Constants.SECTION7_MONTHLY_INCOME,monthly_income);
		prop.setProperty(Constants.SECTION7_RECEIVED_CREDIT,received_credit);
		prop.setProperty(Constants.SECTION7_RECEIVED_CREDIT_VALUE,received_credit_value);
		prop.setProperty(Constants.SECTION7_RECEIVED_CREDIT_VALUE_OTHER,received_credit_value_other);

		prop.save();

		Controller.getLogger().info("- saveProcessPage7");

		PollManager.setCurrentPage(request, 8);

		Controller.forward(request, response, "page_8.jsp");

	}

	public static void saveProcessPage8(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Controller.getLogger().info("+ saveProcessPage8");

		PropertiesConfiguration prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, //
				PropFileRole.LOAD, request.getRequestedSessionId());

		String disabilities[] = TextUtils.escaparArray(request.getParameterValues(Constants.SECTION8_DISABILITIES));
		String security_systems[] = TextUtils.escaparArray(request.getParameterValues(Constants.SECTION8_SECURITY_SYSTEMS));
		String medical_assistance =TextUtils.escaparString(request.getParameter(Constants.SECTION8_MEDICAL_ASSISTANCE));
		String medical_equipment_required =TextUtils.escaparString(request.getParameter(Constants.SECTION8_MEDICAL_EQUIPMENT_REQUIRED));
		String medical_equipment_which =TextUtils.escaparString(request.getParameter(Constants.SECTION8_MEDICAL_EQUIPMENT_WHICH));
		String medical_equipment_has =TextUtils.escaparString(request.getParameter(Constants.SECTION8_MEDICAL_EQUIPMENT_HAS));
		String medical_equipment_other =TextUtils.escaparString(request.getParameter(Constants.SECTION8_MEDICAL_EQUIPMENT_OTHER));

		String medical_assistance_has =TextUtils.escaparString(request.getParameter(Constants.SECTION8_MEDICAL_ASSISTANCE_HAS));
		String pregnant =TextUtils.escaparString(request.getParameter(Constants.SECTION8_PREGNANT));

		String diseases[] =TextUtils.escaparArray(request.getParameterValues(Constants.SECTION8_DISEASES));
		String diseases_other =TextUtils.escaparString(request.getParameter(Constants.SECTION8_DISEASES_OTHER));

		String vaccines_BCG =TextUtils.escaparString(request.getParameter(Constants.SECTION8_VACCINES_BCG));
		String vaccines_Triple =TextUtils.escaparString(request.getParameter(Constants.SECTION8_VACCINES_TRIPLE));
		String vaccines_Trivalente =TextUtils.escaparString(request.getParameter(Constants.SECTION8_VACCINES_TRIVALENTE));
		String vaccines_Polio =TextUtils.escaparString(request.getParameter(Constants.SECTION8_VACCINES_POLIO));
		String vaccines_HepatitisA =TextUtils.escaparString(request.getParameter(Constants.SECTION8_VACCINES_HEPATITISA));
		String vaccines_HepatitisB =TextUtils.escaparString(request.getParameter(Constants.SECTION8_VACCINES_HEPATITISB));
		String vaccines_Meningitis =TextUtils.escaparString(request.getParameter(Constants.SECTION8_VACCINES_MENINGITIS));
		String vaccines_Sarampion =TextUtils.escaparString(request.getParameter(Constants.SECTION8_VACCINES_SARAMPION));

		String prenatal =TextUtils.escaparString(request.getParameter(Constants.SECTION8_PRENATAL));

		prop.setProperty(Constants.SECTION8_DISABILITIES,disabilities);
		prop.setProperty(Constants.SECTION8_SECURITY_SYSTEMS,security_systems);
		prop.setProperty(Constants.SECTION8_MEDICAL_ASSISTANCE,medical_assistance);
		prop.setProperty(Constants.SECTION8_MEDICAL_EQUIPMENT_REQUIRED,medical_equipment_required);
		prop.setProperty(Constants.SECTION8_MEDICAL_EQUIPMENT_WHICH,medical_equipment_which);
		prop.setProperty(Constants.SECTION8_MEDICAL_EQUIPMENT_HAS,medical_equipment_has);
		prop.setProperty(Constants.SECTION8_MEDICAL_EQUIPMENT_OTHER,medical_equipment_other);
		prop.setProperty(Constants.SECTION8_MEDICAL_ASSISTANCE_HAS,medical_assistance_has);

		prop.setProperty(Constants.SECTION8_PREGNANT,pregnant);
		prop.setProperty(Constants.SECTION8_DISEASES,diseases);
		prop.setProperty(Constants.SECTION8_DISEASES_OTHER,diseases_other);
		prop.setProperty(Constants.SECTION8_VACCINES_BCG,vaccines_BCG);
		prop.setProperty(Constants.SECTION8_VACCINES_TRIPLE,vaccines_Triple);
		prop.setProperty(Constants.SECTION8_VACCINES_TRIVALENTE,vaccines_Trivalente);
		prop.setProperty(Constants.SECTION8_VACCINES_POLIO,vaccines_Polio);
		prop.setProperty(Constants.SECTION8_VACCINES_HEPATITISA,vaccines_HepatitisA);
		prop.setProperty(Constants.SECTION8_VACCINES_HEPATITISB,vaccines_HepatitisB);
		prop.setProperty(Constants.SECTION8_VACCINES_MENINGITIS,vaccines_Meningitis);
		prop.setProperty(Constants.SECTION8_VACCINES_SARAMPION,vaccines_Sarampion);
		prop.setProperty(Constants.SECTION8_PRENATAL,prenatal);

		prop.save();

		Controller.getLogger().info("- saveProcessPage8");

		PollManager.setCurrentPage(request, 9);

		Controller.forward(request, response, "page_9.jsp");

	}

}
