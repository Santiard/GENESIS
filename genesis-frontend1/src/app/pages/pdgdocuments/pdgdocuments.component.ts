import { Component } from '@angular/core';
import { AuthService } from '../../core/services/auth/auth.service';

@Component({
  selector: 'app-pdgdocuments',
  standalone: true,
  imports: [],
  templateUrl: './pdgdocuments.component.html',
  styles: ``,
})
export class PdgdocumentsComponent {
  constructor(public authService: AuthService) {}

  onFileSelected(event: Event, update: number): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      const file: File = input.files[0];

      if (file.type != 'application/pdf') {
        alert('Solo se permiten archivos PDF');
        console.error('Solo se permiten archivos PDF');
        return;
      }

      const reader = new FileReader();

      // Leer el archivo como ArrayBuffer
      reader.readAsDataURL(file);

      reader.onload = () => {
        // Obtener el ArrayBuffer
        const base64File = reader.result as string;

        // Convertir el ArrayBuffer a un byte array
        const base64WithoutPrefix = base64File.split(',')[1];

        switch (update) {
          case 1:
            this.authService.updateIcfes(base64WithoutPrefix).subscribe();
            this.authService.account.icfes = base64WithoutPrefix;
            break;
          case 2:
            this.authService.updateRecord(base64WithoutPrefix).subscribe();
            this.authService.account.record = base64WithoutPrefix;
            break;
          case 3:
            this.authService.updateCertificate(base64WithoutPrefix).subscribe();
            this.authService.account.certificate = base64WithoutPrefix;
            break;
        }
      };

      reader.onerror = (error) => {
        alert('Error al leer el archivo');
        console.error('Error al leer el archivo:', error);
      };
    }
  }

  onFileDownload(update: number): void {
    let base64Data: any = null;
    let fileName: string = '';

    switch (update) {
      case 1:
        base64Data = this.authService.account.icfes;
        fileName = 'icfes.pdf';
        break;
      case 2:
        base64Data = this.authService.account.record;
        fileName = 'record.pdf';
        break;
      case 3:
        base64Data = this.authService.account.certificate;
        fileName = 'certificate.pdf';
        break;
    }

    const byteCharacters = atob(base64Data);
    const byteNumbers = new Array(byteCharacters.length);
    for (let i = 0; i < byteCharacters.length; i++) {
      byteNumbers[i] = byteCharacters.charCodeAt(i);
    }
    const byteArray = new Uint8Array(byteNumbers);
    const blob = new Blob([byteArray], { type: 'application/pdf' });

    // Paso 2: Crear una URL para el Blob
    const blobUrl = URL.createObjectURL(blob);

    // Paso 3: Crear un enlace para descargar
    const link = document.createElement('a');
    link.href = blobUrl;
    link.download = fileName;
    link.click();

    // Liberar la URL temporal
    URL.revokeObjectURL(blobUrl);
  }
}
