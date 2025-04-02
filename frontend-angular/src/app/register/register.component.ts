import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  standalone:true,
  selector: 'app-register',
  imports: [
    FormsModule,
    CommonModule,
    RouterLink
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent { 
  firstname: string = '';
  lastname: string = '';
  email: string = '';
  password: string = '';
  successMessage = '';
  errorMessage = '';
  
  constructor(private authService: AuthService,private router: Router){}

  onRegister() {
    const user = {
      firstname: this.firstname,
      lastname: this.lastname,
      email: this.email,
      password: this.password,
    };
  
    this.authService.register(user).subscribe({
      next: (res) => {
        console.log('Inscription réussie !', res);
        this.successMessage = 'Inscription réussie !';
        this.errorMessage = '';
        this.router.navigate(['']);
      },
      error: (err) => {
        console.error('Erreur lors de l’inscription', err);
        this.errorMessage = 'Une erreur est survenue : ' + err.error;
        this.successMessage = '';
      }
    });
  }
}
