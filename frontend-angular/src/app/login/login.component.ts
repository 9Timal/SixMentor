import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';


@Component({
  standalone: true,
  selector: 'app-login',
  imports: [
    FormsModule,
    RouterLink
  ],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  constructor(private authService: AuthService,private router: Router) {}

  onLogin() {
    this.authService.login(this.email, this.password).subscribe({
      next: (res) => {
        console.log("Connexion réussie", res);
        this.router.navigate(['/register']); // Redirection
      },
      error: (err) => {
        console.error("Erreur lors de la connexion", err);
      }
    });
  }

  
}
