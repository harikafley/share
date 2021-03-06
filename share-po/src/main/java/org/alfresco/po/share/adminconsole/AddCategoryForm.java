/*
 * #%L
 * share-po
 * %%
 * Copyright (C) 2005 - 2016 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software. 
 * If the software was purchased under a paid Alfresco license, the terms of 
 * the paid license agreement will prevail.  Otherwise, the software is 
 * provided under the following open source license terms:
 * 
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
package org.alfresco.po.share.adminconsole;

import static com.google.common.base.Preconditions.checkNotNull;

import org.alfresco.po.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * Part of Category Manager page. Showing when you add new category to Page.
 *
 * @author Aliaksei Boole
 */
public class AddCategoryForm extends PageElement
{
    private static By FORM = By.cssSelector("#userInput");
    @SuppressWarnings("unused")
    private static By TITLE_FORM = By.cssSelector("#userInput_h");
    private static By NAME_INPUT = By.cssSelector("div#userInput input[type='text']");
    private static By OK = By.xpath("//span[@class='button-group']/span[1]/span/button");
    private static By CANCEL = By.xpath("//span[@class='button-group']/span[2]/span/button");

    /**
     * Fill field with name new category.
     *
     * @param text new categoryName
     */
    public void fillNameField(String text)
    {
        checkNotNull(text);
        WebElement inputField = driver.findElement(NAME_INPUT);
        inputField.clear();
        if (text != null)
        {
            inputField.sendKeys(text);
        }
    }

    /**
     * Mimic click on OK button.
     */
    public void clickOk()
    {
        click(OK);
    }

    /**
     * Mimic click on Cancel button.
     */
    public void clickCancel()
    {
        click(CANCEL);
    }

    private void click(By locator)
    {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    /**
     * Check that form display on page.
     *
     * @return true - if form displayed.
     */
    public boolean isDisplay()
    {
        try
        {
            return findElement(FORM).isDisplayed();
        }
        catch (NoSuchElementException e) {}
        return false;
    }
}
