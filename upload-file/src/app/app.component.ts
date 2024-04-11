import { Component } from '@angular/core';
import { S3 } from 'aws-sdk';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'upload-file';
  fileName = '';
  file: File | null = null;

  onFileInput(event: any) {
    this.file = event.target.files.item(0);
  }
  onSubmit() {
    console.log(this.file);
    if (!this.file) {
      console.error('file Not selected!!!');
      return;
    }
    const bucketName = 'bucket-name';
    const s3 = new S3({
      //create access key in AWS profile -> security credentials -> access keys 
      accessKeyId: 'access-key',
      secretAccessKey: 'secrect-key',
      region: 'location'
    });

    const params = {
      Bucket: bucketName,
      Key: this.file.name,
      Body: this.file
    };

    s3.upload(params, (err: any, data: any) => {
      if (err) {
        console.error('Error: ', err);
      } else {
        console.log('File uploaded successfully!!!');
      }
    });
  }
}
