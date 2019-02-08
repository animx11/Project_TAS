export class user {
	
	private id: number;
	public userName: String;
	private password: String;
	private email: String;
	private userPermissionGroup: String;
	
	constructor(obj?: any) {
		
		this.id = (obj && obj.id) || 0;
		this.userName = (obj && obj.userName) || '';
		this.password = (obj && obj.password) || '';
		this.email = (obj && obj.email) || '';
		this.userPermissionGroup = (obj && obj.userPermissionGroup) || '';
		
	}

	getId(): number {
		return this.id;
	}
	setId(id: number){
		this.id = id;
	}

	getUserName(): String {
		return this.userName;
	}
	setUserName(userName: String){
		this.userName = userName;
	}	

	getPassword(): String {
		return this.password;
	}
	setPassword(password: String){
		this.password = password;
	}	
	
	getEmail(): String {
		return this.email;
	}
	setEmail(email: String){
		this.email = email;
	}

	getUserPermissionGroup(): String {
		return this.userPermissionGroup;
	}
	setUserPermissionGroup(userPermissionGroup: String){
		this.userPermissionGroup = userPermissionGroup;
	}	

}