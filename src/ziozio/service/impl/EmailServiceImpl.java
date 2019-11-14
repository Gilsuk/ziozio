package ziozio.service.impl;

import ziozio.service.face.EmailService;

public class EmailServiceImpl implements EmailService{
    private EmailServiceImpl() { } 
    private static class Factory {
        public static final EmailService INSTANCE = new EmailServiceImpl();
    }
    public static EmailService getInstance() { return Factory.INSTANCE; }
	@Override
	public void sendLinkForPW(String email) {
	}
    
    
}
