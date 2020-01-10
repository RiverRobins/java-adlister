import java.util.List;

public interface Contacts {
    public long saveContact(Contact contact);
    public List<Contact> getContacts(Contact contact);
    public void deleteContactById(long id);
    public Contact getContactById(long id);
    public List<Contact> getContacts();
//    public List<Contact> getContacts(Contact contact);
}
