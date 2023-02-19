package com.rivaldy.witchsaga.constant;

public class Message {

    public static final String RESPONSE_TEST = "Expected : {}, Actual : {}, Test : {}";

    public static final String GIV_PERSON = "Person %s : Age of Death = %s, Year of Death = %s";
    public static final String ANS_PERSON_NUMBER_OF_KILLED = "Person %s born on Year = %s - %s = %s, number of people killed on year %s is %s.";
    public static final String ANS_AVERAGE_NUMBER_OF_KILLED = "So the average is ( %s )/%s = %s";

    public static final String ERR_DATA_BAD_REQUEST = "Your request was invalid, please check this reasons!";

    public static final String ERR_TOTAL_IS_NOT_MATCH = "Request totalPerson must be equal to size of persons list";
    public static final String ERR_REA_TOTAL_IS_NOT_MATCH = "totalPerson %s is not equal persons data %s";
    public static final String ERR_AGE_MORE_THAN_YEAR = "Request age must be lower equal than year";
    public static final String ERR_REA_AGE_MORE_THAN_YEAR = "Request Age : %s, Year : %s";
}
