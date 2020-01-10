public class DaoFactory {
    private static Ads adsDao;

    private static Contacts contactsDoa;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }
    public static Contacts contactsDoa() {
        if (contactsDoa == null) {
            contactsDoa = new ContactListDao();
        }
        return contactsDoa;
    }
}
