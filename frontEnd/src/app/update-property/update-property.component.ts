import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Property } from '../models/Property';
import { PropertyServiceService } from '../services/property-service.service';

@Component({
  selector: 'app-update-property',
  templateUrl: './update-property.component.html',
  styleUrls: ['./update-property.component.css']
})
export class UpdatePropertyComponent implements OnInit {
  propertyId: number = 0;
  property: Property = {} as Property;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private propertyService: PropertyServiceService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.propertyId = id ? +id : 0;
    this.getProperty();
  }

  getProperty(): void {
    this.propertyService.getPropertyById(this.propertyId).subscribe({
      next: (data) => {
        this.property = data;
      },
      error: (err) => {
        console.error('Error fetching property: ', err);
      }
    });
  }

  updateProperty(): void {
    this.propertyService.updateProperty(this.propertyId, this.property).subscribe({
      next: (updatedProperty) => {
        console.log('Property updated successfully: ', updatedProperty);
        this.router.navigate(['/admin/property', this.propertyId]);
      },
      error: (err) => {
        console.error('Error updating property: ', err);
      }
    });
  }
}
