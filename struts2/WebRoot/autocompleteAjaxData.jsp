<%@page import="org.apache.commons.logging.LogFactory"%>
<%@page import="org.apache.commons.logging.Log"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%!Log log = LogFactory.getLog(getClass());%>
<%
	out.clear();

	request.setCharacterEncoding("UTF-8");

	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);

	String[] countries = { "Afghanistan", "Aland Islands", "Albania",
			"Algeria", "American Samoa (USA)", "Andorra", "Angola",
			"Anguilla", "Antarctica", "Antigua and Barbuda",
			"Argentina", "Armenia", "Aruba", "Australia", "Austria",
			"Azerbaijan", "Bahamas", "Bahrain", "Bangladesh",
			"Barbados", "Belarus", "Belgium", "Belize", "Benin",
			"Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina",
			"Botswana", "Bouvet Island", "Brazil",
			"British Indian Ocean Territory (UK)", "Brunei Darussalem",
			"Bulgaria", "Burkina Faso", "Burundi", "Cambodia",
			"Cameroon", "Canada", "Cape Verde", "Cayman Islands (UK)",
			"Central African Republic", "Chad", "Chile", "China",
			"China (Hong Kong S.A.R.)", "China (Macau S.A.R.)",
			"Christmas Island", "Cocos (Keeling) Islands", "Colombia",
			"Comoros", "Congo",
			"Congo, The Democratic Republic of the (formerly Zaire)",
			"Cook Islands", "Costa Rica", "Croatia", "Cyprus",
			"Czech Republic", "Côte d'Ivoire (Ivory Coast)", "Denmark",
			"Djibouti", "Dominica", "Dominican Republic", "Ecuador",
			"Egypt", "El Salvador", "Equatorial Guinea", "Eritrea",
			"Estonia", "Ethiopia", "Falkland Islands (Malvinas) (UK)",
			"Faroe Islands (Denmark)", "Fiji", "Finland", "France",
			"French Guiana", "French Polynesia",
			"French Southern Territories", "Gabon", "Gambia",
			"Georgia", "Germany", "Ghana", "Gibraltar (UK)", "Greece",
			"Greenland (Denmark)", "Grenada", "Guadeloupe (France)",
			"Guam (USA)", "Guatemala", "Guinea", "Guinea-Bissau",
			"Guyana", "Haiti",
			"Heard and McDonald Islands (Australia)",
			"Holy See (Vatican City State)", "Honduras", "Hungary",
			"Iceland", "India", "Indonesia", "Iraq", "Ireland",
			"Israel", "Italy", "Jamaica", "Japan", "Jordan",
			"Kazakhstan", "Kenya", "Kiribati",
			"Korea, Republic of (South Korea)", "Kuwait", "Kyrgyzstan",
			"Lao People's Democratic Republic (Laos)", "Latvia",
			"Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya",
			"Liechtenstein", "Lithuania", "Luxembourg",
			"Macedonia, The former Yugoslav Republic of", "Madagascar",
			"Malawi", "Malaysia", "Maldives", "Mali", "Malta",
			"Marshall Islands", "Martinique (France)", "Mauritania",
			"Mauritius", "Mayotte (France)", "Mexico",
			"Micronesia, Federated States of", "Moldova, Republic of",
			"Monaco", "Mongolia", "Montenegro", "Montserrat (UK)",
			"Morocco", "Mozambique", "Myanmar (was Burma)", "Namibia",
			"Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
			"New Caledonia", "New Zealand", "Nicaragua", "Niger",
			"Nigeria", "Niue", "Norfolk Island (Australia)",
			"Northern Mariana Islands (USA)", "Norway", "Oman",
			"Pakistan", "Palau (USA)",
			"Palestinian Territory, Occupied", "Panama",
			"Papua New Guinea", "Paraguay", "Peru", "Philippines",
			"Pitcairn (UK)", "Poland", "Portugal", "Puerto Rico (USA)",
			"Qatar", "Romania", "Russian Federation (Russia)",
			"Rwanda", "Réunion (France)", "Saint Helena (UK)",
			"Saint Kitts and Nevis", "Saint Lucia",
			"Saint Pierre and Miquelon (France)",
			"Saint Vincent and the Grenadines", "Samoa", "San Marino",
			"Sao Tome and Principe", "Saudi Arabia", "Senegal",
			"Serbia", "Seychelles", "Sierra Leone", "Singapore",
			"Slovakia", "Slovenia", "Solomon Islands", "Somalia",
			"South Africa",
			"South Georgia and the South Sandwich Islands", "Spain",
			"Sri Lanka", "Suriname", "Svalbard and Jan Mayen (Norway)",
			"Swaziland", "Sweden", "Switzerland", "Taiwan",
			"Tajikistan", "Tanzania, United Republic of", "Thailand",
			"Timor-Leste", "Togo", "Tokelau (New Zealand)", "Tonga",
			"Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan",
			"Turks and Caicos Islands (UK)", "Tuvalu", "Uganda",
			"Ukraine", "United Arab Emirates", "United Kingdom",
			"United States", "United States Minor Outlying Islands",
			"Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam",
			"Virgin Islands, British", "Virgin Islands, U.S.",
			"Wallis and Futuna", "Western Sahara", "Yemen", "Zambia",
			"Zimbabwe", };

	String country = request.getParameter("country");

	if (country == null)
		country = "";

	StringBuffer buffer = new StringBuffer();

	for (int i = 0; i < countries.length; i++) {
		if (countries[i].toLowerCase()
			.startsWith(country.toLowerCase())) {
			if (buffer.length() != 0)
		buffer.append(",");
			buffer.append("['" + countries[i] + "']");
		}
	}
	
	Thread.sleep(500);

	out.print("[" + buffer + "]");

	log.info("queryString: " + request.getQueryString() + ", result: ["
			+ buffer + "]. ");
			
%>
