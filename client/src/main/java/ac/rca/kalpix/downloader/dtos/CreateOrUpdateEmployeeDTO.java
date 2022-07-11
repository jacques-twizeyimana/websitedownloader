package ac.rca.kalpix.downloader.dtos;

import ac.rca.kalpix.downloader.enums.EDepartments;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class CreateOrUpdateEmployeeDTO {
    private Long userId;
    private EDepartments departments;
}
