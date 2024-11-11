import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductData} from "../shared/models/ProductData";
import {Category} from "../shared/models/category";

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  constructor(private http:HttpClient) { }
  private apiUrl = 'http://localhost:8080/api/products';

  getProducts(): Observable<ProductData>{
    return this.http.get<ProductData>(this.apiUrl);
  }

  getBrands(){
    const url = `${this.apiUrl}/brands`
    return this.http.get<Brand[]>(url);
  }

  getCategories(){
    const url = `${this.apiUrl}/categories`
    return this.http.get<Category[]>(url);
  }
}
