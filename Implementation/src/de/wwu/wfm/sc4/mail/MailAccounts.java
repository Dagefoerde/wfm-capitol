package de.wwu.wfm.sc4.mail;
 
public enum MailAccounts
{
	//TODO Configure valid account
    CAPITOL("secmail.uni-muenster.de", 25, "d_over02", "Please fill with your password", "d_over02@uni-muenster.de");
     
    private String smtpHost;
    private int port;
    private String username;
    private String password;
    private String email;
     
    
    private MailAccounts(String smtpHost, int port, String username, String password, String email)
    {
        this.smtpHost = smtpHost;
        this.port = port;
        this.username = username;
        this.password = password;
        this.email = email;
    }
     
    public int getPort()
    {
        return port;
    }
     
    public String getSmtpHost()
    {
        return smtpHost;
    }
     
    public MailAuthenticator getPasswordAuthentication()
    {
        return new MailAuthenticator(username, password);
    }
     
    public String getEmail()
    {
        return email;
    }
}