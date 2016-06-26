#!/bin/sh

##################################################################################
############ Validation shell script for execution for REST API ##################
##################################################################################
###### Shell Script Name : validator.sh ##########################################
###### Supportes Arguments : [start][stop][<password_text_for_service_invocation>]
###### Author : Ashwini Rao ######################################################
###### Last modified date : 22-May-2016 ##########################################
##################################################################################


NOOFARGS=$#
CONNECT_URL=http://localhost:8080

if [ "$NOOFARGS" -ne 1 ]; then
        echo "Invalid Arguments\n"
        echo "Usage Options\n"
        echo "\t$0 \n Option 1 :- /validator.sh start \n Option 2 :- /validator.sh stop \n Option 3 :- /validator.sh  passwordtovalidatetext  \n"
else
		OPTION_ID=$1
        echo "Option selected : $OPTION_ID"
        if [ "$OPTION_ID" == "start" ]; then
         java -jar validator.jar > catalina.out 2>&1 &
         PID=`ps -aef | grep validator.jar |grep -v grep |awk '{print $2}'`
         	while [[ "" !=  "$PID" ]]
         	do
         	echo "Server started."
         	break
         	done         
       	elif [ "$OPTION_ID" == "stop" ]; then         
         	PID=`ps -aef | grep validator.jar |grep -v grep |awk '{print $2}'`
         	while [[ "" !=  "$PID" ]]
         	do
         		echo "Killing server at $PID"
  				kill -9 $PID
  				echo "Server stopped."
         		break
         	done
        else
         echo "Executing service with password = $OPTION_ID \n" 
         #curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET $CONNECT_URL/validate?password="$OPTION_ID"| json_pp
         curl --request GET \
         	   --url $CONNECT_URL/validate?password="$OPTION_ID" \
         	   --header 'accept: application/json' | json_pp
         	   
        fi

fi
