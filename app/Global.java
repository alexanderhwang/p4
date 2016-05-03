import models.Inventory;
import play.*;

public class Global extends GlobalSettings
{
    public void onStart(Application app)
    {
        Inventory.getInstance();
    }
}