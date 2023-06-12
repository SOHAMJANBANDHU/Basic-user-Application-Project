package basicApplication.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class BasicApplication {

		@Id
		private int id;
		private String name;
		private String email;
		private String password;
		private long phone;
		private String facebook;
		private String snapchat;
		private String instagram;
		private String twitter;
		private String whatsapp;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		public String getFacebook() {
			return facebook;
		}
		public void setFacebook(String facebook) {
			this.facebook = facebook;
		}
		public String getSnapchat() {
			return snapchat;
		}
		public void setSnapchat(String snapchat) {
			this.snapchat = snapchat;
		}
		public String getInstagram() {
			return instagram;
		}
		public void setInstagram(String instagram) {
			this.instagram = instagram;
		}
		public String getTwitter() {
			return twitter;
		}
		public void setTwitter(String twitter) {
			this.twitter = twitter;
		}
		public String getWhatsapp() {
			return whatsapp;
		}
		public void setWhatsapp(String whatsapp) {
			this.whatsapp = whatsapp;
		}
		
		
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone
					+ ", facebook=" + facebook + ", snapchat=" + snapchat + ", instagram=" + instagram + ", twitter="
					+ twitter + ", whatsapp=" + whatsapp + "]";
		}

}
