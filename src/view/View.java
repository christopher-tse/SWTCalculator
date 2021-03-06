package view;

import controller.Controller;
import model.Listener;
import model.Model;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by christophertse on 2017/02/23.
 */
public class View implements Listener{
    Model m;
    Controller c;
    Text numdisplay;
    Label err;

    public View(Controller c, Model m) {
        this.m = m;
        this.c = c;
        m.addListener(this);
        init();

    }

    private void init() {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(4, true));
        shell.setSize(500, 400);

        GridData square = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
        GridData longspan = new GridData(SWT.FILL, SWT.TOP, false, false, 4, 1);

        numdisplay = new Text(shell, SWT.RIGHT | SWT.BORDER);
        numdisplay.setText("0");
        numdisplay.setLayoutData(longspan);
        numdisplay.setEditable(false);

        err = new Label(shell, SWT.RIGHT);
        err.setLayoutData(longspan);
        Color red = new Color(display, 255, 0, 0);
        err.setForeground(red);

        Button delButton = new Button(shell, SWT.PUSH);
        delButton.setLayoutData(square);
        delButton.setText("Del");
        delButton.addSelectionListener(c);

        Label blank1 = new Label(shell, SWT.NONE);
        blank1.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 3, 1));

        Button clrButton = new Button(shell, SWT.PUSH);
        clrButton.setLayoutData(square);
        clrButton.setText("Clear");
        clrButton.addSelectionListener(c);

        Button mInButton = new Button(shell, SWT.PUSH);
        mInButton.setLayoutData(square);
        mInButton.setText("M+");
        mInButton.addSelectionListener(c);

        Button mCallButton = new Button(shell, SWT.PUSH);
        mCallButton.setLayoutData(square);
        mCallButton.setText("MRC");
        mCallButton.addSelectionListener(c);

        Button addButton = new Button(shell, SWT.PUSH);
        addButton.setLayoutData(square);
        addButton.setText("+");
        addButton.addSelectionListener(c);

        Button oneButton = new Button(shell, SWT.PUSH);
        oneButton.setLayoutData(square);
        oneButton.setText("1");
        oneButton.addSelectionListener(c);

        Button twoButton = new Button(shell, SWT.PUSH);
        twoButton.setLayoutData(square);
        twoButton.setText("2");
        twoButton.addSelectionListener(c);

        Button threeButton = new Button(shell, SWT.PUSH);
        threeButton.setLayoutData(square);
        threeButton.setText("3");
        threeButton.addSelectionListener(c);

        Button minusButton = new Button(shell, SWT.PUSH);
        minusButton.setLayoutData(square);
        minusButton.setText("-");
        minusButton.addSelectionListener(c);

        Button fourButton = new Button(shell, SWT.PUSH);
        fourButton.setLayoutData(square);
        fourButton.setText("4");
        fourButton.addSelectionListener(c);

        Button fiveButton = new Button(shell, SWT.PUSH);
        fiveButton.setLayoutData(square);
        fiveButton.setText("5");
        fiveButton.addSelectionListener(c);

        Button sixButton = new Button(shell, SWT.PUSH);
        sixButton.setLayoutData(square);
        sixButton.setText("6");
        sixButton.addSelectionListener(c);

        Button timesButton = new Button(shell, SWT.PUSH);
        timesButton.setLayoutData(square);
        timesButton.setText("*");
        timesButton.addSelectionListener(c);

        Button sevenButton = new Button(shell, SWT.PUSH);
        sevenButton.setLayoutData(square);
        sevenButton.setText("7");
        sevenButton.addSelectionListener(c);

        Button eightButton = new Button(shell, SWT.PUSH);
        eightButton.setLayoutData(square);
        eightButton.setText("8");
        eightButton.addSelectionListener(c);

        Button nineButton = new Button(shell, SWT.PUSH);
        nineButton.setLayoutData(square);
        nineButton.setText("9");
        nineButton.addSelectionListener(c);

        Button divButton = new Button(shell, SWT.PUSH);
        divButton.setLayoutData(square);
        divButton.setText("/");
        divButton.addSelectionListener(c);

        Button dotButton = new Button(shell, SWT.PUSH);
        dotButton.setLayoutData(square);
        dotButton.setText(".");
        dotButton.addSelectionListener(c);

//        Button debug = new Button(shell, SWT.PUSH);
//        debug.setLayoutData(square);
//        debug.setText("Debug");
//        debug.addSelectionListener(c);

        //Label blank = new Label(shell, SWT.NONE);

        Button zeroButton = new Button(shell, SWT.PUSH);
        zeroButton.setLayoutData(square);
        zeroButton.setText("0");
        zeroButton.addSelectionListener(c);

        Button expButton = new Button(shell, SWT.PUSH);
        expButton.setLayoutData(square);
        expButton.setText("^");
        expButton.addSelectionListener(c);

        Button eqButton = new Button(shell, SWT.PUSH);
        eqButton.setLayoutData(square);
        eqButton.setText("=");
        eqButton.addSelectionListener(c);



        shell.open();

        // run the event loop as long as the window is open
        while (!shell.isDisposed()) {
            // read the next OS event queue and transfer it to a SWT event
            if (!display.readAndDispatch())
            {
                // if there are currently no other OS event to process
                // sleep until the next OS event is available
                display.sleep();
            }
        }
    }


    @Override
    public void numberChanged(String display) {
        //System.out.println("Number changed");
        err.setText("");
        numdisplay.setText(display);
        numdisplay.getParent().layout();
    }

    @Override
    public void invalidCompute() {
        err.setText("Invalid expression");
        err.getParent().layout();
    }
}
