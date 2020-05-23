package com.andrea.puccia;

import org.assertj.swing.annotation.GUITest;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.runner.GUITestRunner;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewTest extends AssertJSwingJUnitTestCase {
    private FrameFixture window;

    private View view;

    @Override
    protected void onSetUp() {
        GuiActionRunner.execute(() -> {
            view = View.createView();
            return view;
        });
        window = new FrameFixture(robot(), view);
        window.show();
    }

    @Test
    @GUITest
    public void testRobot() {
        window.textBox("helloText").enterText("klsjdalkfjasdflksdnfln");
    }

    @Test
    public void testLabel() {
        assertThat(window.label("label").text()).isEqualTo("Label test");
    }
}
