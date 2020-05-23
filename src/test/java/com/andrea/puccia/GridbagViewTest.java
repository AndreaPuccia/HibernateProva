package com.andrea.puccia;

import org.assertj.swing.annotation.GUITest;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.runner.GUITestRunner;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GUITestRunner.class)
public class GridbagViewTest extends AssertJSwingJUnitTestCase {

    FrameFixture window;
    GridBagView view;

    @Override
    protected void onSetUp() {
        GuiActionRunner.execute(() -> {
            view = new GridBagView();
            return view;
        });
        window = new FrameFixture(robot(), view);
        window.show(); // shows the frame to test
    }

    @Test
    @GUITest
    public void testControlsInitialStates() {
        assertThat(window.button("studentButton").isEnabled()).isEqualTo(false);
        assertThat(window.button("ButtonId").isEnabled()).isEqualTo(false);
        assertThat(window.textBox("TextId").text()).isEqualTo("");
        assertThat(window.label("MyId").text()).isEqualTo("MyId");
        assertThat(window.label("PrintId").text()).isEqualTo("Printed text");
        assertThat(window.label("studentLabel").text()).isEqualTo("No Student Info");
        Student s = new Student();
        s.setMatricola(1);
        s.setCognome("andrea");
        s.setNome("puccia");
        System.out.println(s.toString());
        assertThat(window.list("studentList").contents())
                .containsExactly(s.toString());
    }
    @Test
    @GUITest
    public void writeTextIntoTextBoxEnablingButton() {
        window.textBox("TextId").enterText("ciao");
        assertThat(window.button("ButtonId").isEnabled()).isEqualTo(true);
    }
    @Test
    @GUITest
    public void writeNoTextIntoTextBoxEnablingButton() {
        window.textBox("TextId").enterText(" ");
        assertThat(window.button("ButtonId").isEnabled()).isEqualTo(false);
    }
    @Test
    @GUITest
    public void writeTextIntoTextBoxAndPressButtonPrintOnLabel() {
        window.textBox("TextId").enterText("ciao");
        window.button("ButtonId").click();
        assertThat(window.label("PrintId").text()).isEqualTo("ciao");
    }

    @Test
    @GUITest
    public void selectItemInListEnablingButton() {
        window.list("studentList").selectItem(0);
        assertThat(window.button("studentButton").isEnabled()).isEqualTo(true);
    }

    @Test
    @GUITest
    public void selectItemInListPressButtonPrintInfo() {
        window.list("studentList").selectItem(0);
        window.button("studentButton").click();
        assertThat(window.label("studentLabel").text())
                .isEqualTo("Student{matricola=1, nome='puccia', cognome='andrea'}");
    }

//    Student{matricola=1, nome='puccia', cognome='andrea'}


}
