package testframe.managers;

import testframe.pages.Poisk;
import testframe.pages.StartPage;

public class PageManager {
    private static PageManager pageManager;

    private StartPage startPage;

    private Poisk createKomPage;

    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }
    public Poisk getPoisk() {
        if (createKomPage == null) {
            createKomPage = new Poisk();
        }
        return createKomPage;
    }



}
