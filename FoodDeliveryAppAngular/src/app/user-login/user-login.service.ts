import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { UserLoginRequest } from "../dto/UserLoginRequest";
import { HttpClient } from "@angular/common/http";


@Injectable({
    providedIn: 'root'
})
export class UserLoginService {

    private url = 'http://127.0.0.1:8080/loginuser';

    constructor(private http: HttpClient) { }

    validateLoginAndGetConfirmedUser(userLoginRequest: UserLoginRequest): Observable<any>{
        return this.http.post<any>(this.url, userLoginRequest);
    }
    
}