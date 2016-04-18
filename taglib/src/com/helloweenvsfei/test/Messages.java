/*
 * IBM Confidential
 * 
 * OCO Source Materials
 * 
 * #ID# IBM CRL Supply Chain Management Research
 * 
 * (C) Copyright IBM Corp. 2005, 2006
 * 
 * The source code for this program is not published or otherwise divested of
 * its trade secrets.
 * 
 */
package com.helloweenvsfei.test;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages
{
    private static final String         BUNDLE_NAME     = "com.helloweenvsfei.test.messages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
                                                                .getBundle(BUNDLE_NAME);

    private Messages()
    {
    }

    public static String getString(String key)
    {
        try
        {
            return RESOURCE_BUNDLE.getString(key);
        }
        catch (MissingResourceException e)
        {
            return '!' + key + '!';
        }
    }

    public static String getString(String key, Object... params)
    {
        try
        {
            String value = RESOURCE_BUNDLE.getString(key);

            return MessageFormat.format(value, params);

        }
        catch (MissingResourceException e)
        {
            return '!' + key + '!';
        }
    }
}

// end
