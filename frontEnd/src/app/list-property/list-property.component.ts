import { Component } from '@angular/core';
import { PropertyServiceService } from '../services/property-service.service';
import { Property } from '../models/Property';

@Component({
  selector: 'app-list-property',
  templateUrl: './list-property.component.html',
  styleUrls: ['./list-property.component.css']
})
export class ListPropertyComponent {
  listProperty: Property[] = [];
  filteredProperties: Property[] = []; 
  showAvailableOnly: boolean = false; 
  selectedType: string = 'all';
  searchTerm: string = ''; 

  constructor(private propertyService: PropertyServiceService) {}

  ngOnInit(): void {
    this.propertyService.getAllProperties().subscribe({
      next: (data) => {
        this.listProperty = data;
        this.applyFilters(); 
      },
      error: (err) => console.log(err)
    });
  }

  getStarsArray(averageRating: number): string[] {
    const fullStars = Math.floor(averageRating);
    const halfStar = averageRating % 1 !== 0;
    const emptyStars = 5 - fullStars - (halfStar ? 1 : 0);

    const starsArray: string[] = [];
    for (let i = 0; i < fullStars; i++) {
      starsArray.push('fas fa-star text-warning');
    }
    if (halfStar) {
      starsArray.push('fas fa-star-half-alt text-warning');
    }
    for (let i = 0; i < emptyStars; i++) {
      starsArray.push('far fa-star text-warning');
    }

    return starsArray;
  }

  applyFilters(): void {
    let filteredProperties = [...this.listProperty];

    if (this.searchTerm.trim() !== '') {
      const searchTermLower = this.searchTerm.toLowerCase();
      filteredProperties = filteredProperties.filter(property =>
        property.title.toLowerCase().includes(searchTermLower) ||
        property.location.toLowerCase().includes(searchTermLower)
      );
    }

    if (this.showAvailableOnly) {
      filteredProperties = filteredProperties.filter(property => property.status === 'Available');
    }

    if (this.selectedType !== 'all') {
      filteredProperties = filteredProperties.filter(property => {
        if (this.selectedType === 'rent') {
          return property.type === 'Rent';
        } else if (this.selectedType === 'sale') {
          return property.type === 'Sale';
        }
        return true; 
      });
    }

    this.filteredProperties = filteredProperties;
  }
}
