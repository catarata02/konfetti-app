node {
    // ========================================================================
    stage 'Compile'
    // ========================================================================
    checkout scm
    sh "./mvnw compile"
    step([$class: 'JUnitResultArchiver', testResults: '**/target/*-reports/TEST-*.xml'])

    // ========================================================================
    stage 'Tests'
    // ========================================================================
    sh "./mvnw verify"
}