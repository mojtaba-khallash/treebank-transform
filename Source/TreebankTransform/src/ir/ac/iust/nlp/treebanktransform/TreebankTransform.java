package ir.ac.iust.nlp.treebanktransform;

/*
* Copyright (C) 2013 Iran University of Science and Technology
*
* This file is part of "Treebank Transform" Project, as available 
* from http://nlp.iust.ac.ir This file is free software;
* you can redistribute it and/or modify it under the terms of the GNU General 
* Public License (GPL) as published by the Free Software Foundation, in 
* version 2 as it comes in the "COPYING" file of the VirtualBox OSE 
* distribution. VirtualBox OSE is distributed in the hope that it will be 
* useful, but WITHOUT ANY WARRANTY of any kind.
*
* You may elect to license modified versions of this file under the terms 
* and conditions of either the GPL.
*/

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Mojtaba Khallash
 */
public class TreebankTransform {

    public static void main(String[] args) {
        TreebankTransformer application = new TreebankTransformer();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(application);
            application.pack();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        application.setVisible(true);
    }
}