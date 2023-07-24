package org.example.cayenne.persistent;

import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class CayenneWicketApplication extends WebApplication {

    private ServerRuntime cayenneRuntime;

    @Override
    protected void init() {
        super.init();
        cayenneRuntime = ServerRuntime.builder()
                .addConfig("cayenne-project.xml")
                .build();
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return BookListPage.class;
    }

    public ServerRuntime getCayenneRuntime() {
        return cayenneRuntime;
    }
}

