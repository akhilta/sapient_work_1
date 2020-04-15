node{
  stage('SCM Checkout'){
   
    git 'https://github.com/akhilta/sapient_work_1.git'
  }
  stage('Compile-Package'){
     bat "mvn package"
          bat label: '', script: 'java -cp my-app-1.0-SNAPSHOT.jar com.mycompany.app.App'

  }
}
