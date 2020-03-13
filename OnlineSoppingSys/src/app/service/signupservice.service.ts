import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

export class CustomerAddress {
  constructor(public street: string,
              public city: string) {
  }
}

export class CustomerDetails {
  constructor(public customerName: string,
              public email: string,
              public password: string,
              public customerAddress: CustomerAddress) {
  }
}

@Injectable({
  providedIn: 'root'
})
export class SignupserviceService {

  constructor(private httpClient: HttpClient) { }

  public createUser(user) {
    return this.httpClient.post<CustomerDetails>('http://localhost:2020/customer/CustomerDetails', user);
  }
}
