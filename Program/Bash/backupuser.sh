#!/bin/bash
searchuser=`cat /etc/passwd | grep /home | cut -d ":" -f 1`
date=`date +%F`

select opt in $searchuser "QUIT"; do
	
	case $opt in
		
		"QUIT") exit 0 ;;
		
		*) tar -czf $opt\_$date.tar.gz /home/$opt 2> /dev/null ;;

	esac

done
