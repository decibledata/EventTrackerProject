import { Vault } from './../../models/vault';
import { VaultService } from './../../services/vault.service';
import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  imports: [
    CommonModule,
    FormsModule,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  vaults: Vault[] = [];

  constructor(
  private vaultService: VaultService,
  ){}

  ngOnInit(): void {
    this.loadVault();
  }

  loadVault(): void {
  this.vaultService.index().subscribe( {
  next: (Vault) => {
    this.vaults = Vault;

  },
  error: (someError) => {
    console.error('HomeComponent.loadVault: error');
    console.error(someError);
  },
} );
  }

}
