import { Component } from '@angular/core';
import { Property, PropertyStatus, PropertyType } from '../models/Property';
import { Router } from '@angular/router';
import { PropertyServiceService } from '../services/property-service.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-property',
  templateUrl: './add-property.component.html',
  styleUrl: './add-property.component.css'
})
export class AddPropertyComponent {
  property: Property = new Property(0, '', '', 0, '', PropertyType.Sale, PropertyStatus.Available, new Date(), '');
  FormAddProperty = new FormGroup({
    title:new FormControl('',Validators.required),
    description:new FormControl('',Validators.required),
    price:new FormControl('',[Validators.required,Validators.min(0)]),
    location:new FormControl('',Validators.required),
    type:new FormControl('',Validators.required),
  })

  constructor(private propertyService: PropertyServiceService, private router: Router) {}

  onFileChange(event: any) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.property.image = btoa(e.target.result);
      };
      reader.readAsBinaryString(file);
    }
  }

  onSubmit() {
    if (this.property.postedDate!=null) {
      this.property.postedDate = new Date(this.property.postedDate); // Ensure property.date is a Date object
    }
    this.propertyService.createProperty(this.property).subscribe({
      next: () => this.router.navigate(['/admin/property']),
      error: (err) => console.error('Error creating property: ', err)
    });
  }
}
