import { Vault } from './../models/vault';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VaultService {

  private url = environment.baseUrl + 'api/vaults';

  constructor(
    private http: HttpClient
  ) { }

  index(): Observable<Vault[]> {
    return this.http.get<Vault[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error(
              "VaultService.index(): error retrieving vault list: "
            )
        )
      })
    )
  }


}
