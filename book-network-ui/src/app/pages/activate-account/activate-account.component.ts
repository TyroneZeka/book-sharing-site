import {Component} from '@angular/core';
import {AuthenticationService} from "../../services/services/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-activate-account',
  templateUrl: './activate-account.component.html',
  styleUrl: './activate-account.component.scss'
})
export class ActivateAccountComponent {
  message: string = '';
  isOkay: boolean = false;
  submitted: boolean = false;

  constructor(
    private authService: AuthenticationService,
    private router: Router,
  ) {
  }

  onCodeCompleted(token: string) {
    this.confirmAccount(token);

  }

  redirectToLogin() {
    this.router.navigate(['login']);
  }

  private confirmAccount(token: string) {
    this.authService.confirm({
      token: token,
    }).subscribe({
        next: () => {
          this.message = 'Your account has been activated.';
          this.submitted = true;
          this.isOkay = true;
        },
        error: () => {
          this.message = 'Token has expired or is invalid.';
          this.submitted = true;
          this.isOkay = false;
        }
      }
    );
  }
}
