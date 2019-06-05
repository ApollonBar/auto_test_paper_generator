package ga;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


public class Population {
	private Individual[] population;
	private double populationFitness = 0.00;
	
	public Population(int size) {
		this.populationFitness = 0.00;
		this.population = new Individual[size];
	}
	
	/**�����Ⱥ�����и���
	 * @return ������Ⱥ���и��������
	 */
	public Individual[] getIndividuals() {
		return this.population;
	}
	
	/**�����Ⱥ��Ӧ��
	 * @return ������Ⱥ��Ӧ��
	 */
	public double getPopulationFitness() {
		return populationFitness;
	}
	
	/**������Ⱥ��Ӧ��
	 * @param populationFitness ������Ⱥ��Ӧ��
	 */
	public void setPopulationFitness(double populationFitness) {
		this.populationFitness = populationFitness;
	}
	
	/**�����Ⱥ��С
	 * @return ������Ⱥ��С
	 */
	public int size() {
		return this.population.length;
	}
	
	/**�÷����Ƚ���Ⱥ����Ӧ��������Ӧ�ȸߵ����������ǰ�棬���±�Ϊ0�ĸ�����Ӧ����ߣ���Ȼ�󷵻ص�offset������ʵĸ���
	 * @param offset λ�ƣ�ƫ������
	 * @return ��offset������ʵĸ���
	 */
	public Individual getFittest(int offset) {
		Arrays.sort(this.population, new Comparator<Individual>() {

			@Override
			public int compare(Individual o1, Individual o2) {
				if(o1.getFitness() > o2.getFitness()) {
					return -1;
				}else if(o1.getFitness() < o2.getFitness()) {
					return 1;
				}
				return 0;
			}
		});
		return this.population[offset];
	}
	
	/**����Ⱥ�е�offsetλ�õĸ������ó�ָ���ĸ���individual
	 * @param offset ָ��λ��
	 * @param individual ָ������
	 */
	public void setInividual(int offset, Individual individual) {
		this.population[offset] = individual;
	}
	
	public Individual getIndividual(int index) {
		return population[index];
	}
	
	/**
	 * ������Ⱥ�и������˳��
	 */
	public void shuffle(){
		Random rand = new Random();
		for(int i=this.population.length-1; i>0; i--) {
			int index = rand.nextInt(i+1);
			 Individual temp = population[i];
			 population[i] = population[index];
			 population[index] = temp;
		}
	}
	
	
}
