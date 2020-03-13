import { Component, OnInit } from '@angular/core';
import {CustomerAddress, CustomerDetails, SignupserviceService} from '../service/signupservice.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  address: CustomerAddress = new CustomerAddress('', '');
  user: CustomerDetails  = new CustomerDetails('', '', '', this.address);

  constructor(private signupserviceService: SignupserviceService) { }

  ngOnInit(): void {
  }

  createUser(): void {
    this.signupserviceService.createUser(this.user)
      .subscribe(data => {
        console.log(data);
      }, error => {
        console.log(error);
      });
  }
}
