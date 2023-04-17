package org.example.framework.base;

import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public  static BasePage actualPage;
     public <TPage extends  BasePage> TPage getInstance(Class<TPage>page){
         Object abj = PageFactory.initElements(DriverFactory.getInstance().getDriver(), page);
      return  page.cast(abj);
     }
     public <TPage extends BasePage> TPage as(Class<TPage>pageInstance){
         try{
             return (TPage) this;
         }catch (Exception e ){
             e.getStackTrace();
         }
         return  null;
     }
}
