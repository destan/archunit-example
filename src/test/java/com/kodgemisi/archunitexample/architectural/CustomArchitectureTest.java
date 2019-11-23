package com.kodgemisi.archunitexample.architectural;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.transaction.Transactional;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(packages = "com.kodgemisi")
public class CustomArchitectureTest {

    @ArchTest
    static final ArchRule SERVICE_ACCESS_RULE = classes()
        .that().haveNameMatching(".*Service")
        .should().onlyBeAccessed().byClassesThat().haveNameMatching(".*Service|.*Controller")
		//.as("Service beans should only be accessed from a controller or another service")
		;

    @ArchTest
	static final ArchRule NON_PUBLIC_CONTROLLER_CLASS_RULE = classes()
			.that().areAnnotatedWith(Controller.class)
			.should().notBePublic();

	@ArchTest
	static final ArchRule NON_PUBLIC_CONTROLLER_METHOD_RULE = methods()
			.that().areDeclaredInClassesThat().areAnnotatedWith(Controller.class)
			.should().notBePublic();

	@ArchTest
	static final ArchRule TRANSACTIONAL_METHODS_SHOULD_BE_PUBLIC_RULE = methods()
			.that().areAnnotatedWith(Transactional.class)
			.should().bePublic();


	@ArchTest
	static final ArchRule entityRule = classes()
			.that().areAnnotatedWith(Entity.class)
			.should(new ArchCondition<>("have no-args constructor") {
				@Override
				public void check(JavaClass item, ConditionEvents events) {
					try {
						item.getConstructor();
						String message = String.format("Class %s have a no-args constructor", item.getFullName());
						events.add(SimpleConditionEvent.satisfied(item, message));
					}
					catch (IllegalArgumentException e) {
						String message = String.format("Class %s does not have a no-args constructor", item.getFullName());
						events.add(SimpleConditionEvent.violated(item, message));
					}
				}
			});

}