import {Component, Input, OnInit} from '@angular/core';
import {StoreService} from "./store.service";
import {Product} from "../shared/models/product";

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss']
})
export class StoreComponent implements OnInit {
  constructor(private storeService: StoreService) {
    this.storeService = storeService;
  }
  products: Product[] = [];
  @Input() title: string = '';

  ngOnInit(): void {
    this.storeService.getProducts().subscribe({
      next: (data) => {
        this.products = data.content;
      },
      error: (error) => {
        console.log('Error fetching data', error)
      }
    });
  }
}
