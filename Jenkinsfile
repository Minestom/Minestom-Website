node {
    stage('Checkout VCS') {
        checkout scm
    }

    stage('Build JAR with Gradle') {
        script {
            sh 'chmod +x ./gradlew'
            sh './gradlew shadowJar --no-daemon'
        }
    }

    stage('Build Image') {
        docker.build("minestom-website:latest")
    }

    stage('Stop and Remove Container') {
        sh('docker stop MinestomWebsite || true && docker rm MinestomWebsite || true')
    }

    stage('Run Container') {
        sh '''
             set +x
             docker run -d -p ${PORT}:8080 --name MinestomWebsite --restart=unless-stopped minestom-website:latest
             set -x
        '''
    }
}