/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package tasksexec

import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import spock.lang.Specification

/**
 * A simple unit test for the 'tasksexec.greeting' plugin.
 */
class TasksexecPluginTest extends Specification {
    def "plugin registers task"() {
        given:
        def project = ProjectBuilder.builder().build()

        when:
        project.plugins.apply("tasksexec.greeting")

        then:
        project.tasks.findByName("greeting") != null
    }
}