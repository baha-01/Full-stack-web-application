import { Component, OnInit } from '@angular/core';
import { PropertyServiceService } from '../services/property-service.service';
import { Property } from '../models/Property';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-property-admin',
  templateUrl: './list-property-admin.component.html',
  styleUrls: ['./list-property-admin.component.css']
})
export class ListPropertyAdminComponent implements OnInit {
  listProperty: Property[] = [];
  filteredProperties: Property[] = []; 
  showAvailableOnly: boolean = false;
  selectedType: string = 'all'; 
  searchTerm: string = '';

  constructor(private propertyService: PropertyServiceService, private router: Router) {}

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

  viewDetails(propertyId: number): void {
    this.router.navigate(['/admin/property', propertyId]);
  }

  updateProperty(propertyId: number): void {
    this.router.navigate(['/update-property', propertyId]);
  }

  deleteProperty(propertyId: number): void {
    if (confirm('Are you sure you want to delete this property?')) {
      this.propertyService.deleteProperty(propertyId).subscribe({
        next: () => {
          this.listProperty = this.listProperty.filter(property => property.propertyId !== propertyId);
          this.applyFilters();
        },
        error: (err) => console.error('Error deleting property: ', err)
      });
    }
  }
}
