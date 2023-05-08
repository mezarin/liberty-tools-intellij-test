     if [[ $GITHUB_ENV ]]; then
	      echo "JAVA_HOME=bla"
     else
        echo "hi this is expcted"
        echo $HI
     fi
