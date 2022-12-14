package com.batch.goodTeam.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.batch.goodTeam.entity.MyUser;
import com.batch.goodTeam.process.DeptNameProcessor;
import com.batch.goodTeam.writer.DBWriter;

@Configuration
@EnableBatchProcessing
public class CsvToH2dbJobConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job csvToH2Job() {
		return jobBuilderFactory.get("csvToH2Job")
				.start(csvToH2Step(null,null))
				.build();
	}
	@Bean
	public Step csvToH2Step(DeptNameProcessor processor, DBWriter writer) {
		
		return stepBuilderFactory.get("csvToH2Step")
				.<MyUser,MyUser>chunk(100)
				.reader(csvItemReader())
				.processor(processor)
				.writer(writer)
				.build();
	}
	
	 @Bean
	    public FlatFileItemReader<MyUser> csvItemReader() {

	        FlatFileItemReader<MyUser> flatFileItemReader = new FlatFileItemReader<>();
	        flatFileItemReader.setResource(new FileSystemResource("C:\\Develop\\Project\\goodTeam.zip_expanded\\goodTeam\\src\\main\\resources/users.csv"));
	        flatFileItemReader.setLinesToSkip(1);
	        flatFileItemReader.setLineMapper(lineMapper());
	        return flatFileItemReader;
	    }

	    /**
	     * CSV data ?????? Map<MyUser>
	     * @return
	     */
	    @Bean
	    public LineMapper<MyUser> lineMapper() {

	        DefaultLineMapper<MyUser> defaultLineMapper = new DefaultLineMapper<>();
	        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

	        lineTokenizer.setDelimiter(",");
	        lineTokenizer.setStrict(false);
	        lineTokenizer.setNames("id", "name", "dept", "salary");

	        BeanWrapperFieldSetMapper<MyUser> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	        fieldSetMapper.setTargetType(MyUser.class);

	        defaultLineMapper.setLineTokenizer(lineTokenizer);
	        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

	        return defaultLineMapper;
	    }
	
}
