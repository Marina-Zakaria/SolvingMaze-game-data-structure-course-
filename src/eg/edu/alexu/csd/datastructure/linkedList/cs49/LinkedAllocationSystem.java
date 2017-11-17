package eg.edu.alexu.csd.datastructure.linkedList.cs49;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class LinkedAllocationSystem implements IPolynomialSolver {
	SinglyLinkedList first, B, C, R;

	@Override
	public void setPolynomial(final char poly, final int[][] terms) {
		// TODO Auto-generated method stub
		if (poly != 'A' && poly != 'B' && poly != 'C') {
			throw null;
		}

		// make an ordered 1 D array of coefficients
		int max = terms[0][1];
		int maxIndex = 0;
		int[] coefficients;
		for (int i = 1; i < terms.length; i++) {
			if (terms[i][1] > max) {
				throw null;
			}
		}
		coefficients = new int[max + 1];
		int counter = 0;
		coefficients[counter++] = terms[maxIndex][0];

		for (int i = max - 1; i >= 0; i--) {
			for (int j = 0; j < terms.length; j++) {
				if (terms[j][1] == i) {
					coefficients[counter++] = terms[j][0];
					break;
				}
				if (j == terms.length - 1) {
					coefficients[counter++] = 0;
				}
			}

		}
		// set the polynomial chosen
		switch (poly) {
		case 'A':
			first = new SinglyLinkedList();
			for (int i = coefficients.length - 1; i >= 0; i--) {
				// System.out.println("h");
				first.add(coefficients[i]);

			}
			break;
		case 'B':
			B = new SinglyLinkedList();
			for (int i = coefficients.length - 1; i >= 0; i--) {
				B.add(coefficients[i]);

			}
			break;
		case 'C':
			C = new SinglyLinkedList();
			for (int i = coefficients.length - 1; i >= 0; i--) {
				C.add(coefficients[i]);

			}
			break;
		default:
			throw null;
		}

	}

	@Override
	public String print(char poly) {
		SinglyLinkedList temp = new SinglyLinkedList();

		switch (poly) {
		case 'A':
			try {
				if (first.isEmpty()) {
					throw null;
				} else {
					for (int i = 0; i < first.size(); i++) {
						temp.add(first.get(i));
					}
					break;
				}
			} catch (Exception e) {
				return null;
			}
		case 'B':
			try {
				if (B.isEmpty()) {
					throw null;
				} else {
					for (int i = 0; i < B.size(); i++) {
						temp.add(B.get(i));
					}
					break;
				}
			} catch (Exception e) {
				throw null;
			}

		case 'C':
			try {
				if (C.isEmpty()) {
					throw null;
				} else {
					for (int i = 0; i < C.size(); i++) {
						temp.add(C.get(i));
					}
					break;

				}
			} catch (Exception e) {
				throw null;
			}

		case 'R':
			try {
				if (R.isEmpty()) {
					throw null;
				} else {
					for (int i = 0; i < R.size(); i++) {
						temp.add(R.get(i));
					}
					break;
				}
			} catch (Exception e) {
				return null;
			}

		default:
			throw null;

		}
		String result = new String();

		for (int i = temp.size - 1; i > 0; i--) {
			switch ((int) temp.get(i)) {
			case 1:

				result = result + "+x" + ((i == 1) ? "" : "^" + Integer.toString(i));

				break;
			case -1:

				result = result + "-x" + ((i == 1) ? "" : "^" + Integer.toString(i));
				break;
			case 0:
				break;
			default:

				if ((int) temp.get(i) > 0 && i != temp.size - 1) {
					result = result + "+" + Integer.toString((int) temp.get(i)) + "x"
							+ ((i == 1) ? "" : "^" + Integer.toString(i));
				} else {
					result = result + Integer.toString((int) temp.get(i)) + "x"
							+ ((i == 1) ? "" : "^" + Integer.toString(i));

				}
				break;
			}

		}
		if ((int) temp.get(0) != 0) {
			result = result + (((int) temp.get(0) < 0) ? "" : "+") + (Integer.toString((int) temp.get(0)));

		}
		System.out.println(result);
		return result;

	}

	@Override
	public void clearPolynomial(final char poly) {
		switch (poly) {
		case 'A':
			try {
				if (!first.isEmpty()) {
					first.clear();
				}
			} catch (Exception e) {
				throw null;
			}
			break;
		case 'B':
			try {
				if (!B.isEmpty()) {
					B.clear();
				}
			} catch (Exception e) {
				throw null;
			}

			break;
		case 'C':
			try {
				if (!C.isEmpty()) {
					C.clear();
				}
			} catch (Exception e) {
				throw null;
			}
			break;
		case 'R':
			try {
				if (!R.isEmpty()) {
					R.clear();
				}
			} catch (Exception e) {
				throw null;
			}

			break;

		default:
			throw null;
		}

	}

	@Override
	public float evaluatePolynomial(final char poly, final float value) {
		// TODO Auto-generated method stub
		switch (poly) {
		case 'A':
			if (first.size == 0) {
				return 0;
			} else {
				float evaluation = 0;
				for (int i = 0; i < first.size; i++) {
					evaluation += (float) Math.pow(value, i) * (int) first.get(i);
				}
				return evaluation;
			}

		case 'B':
			if (B.size == 0) {
				return 0;
			} else {
				float evaluation = 0;
				for (int i = 0; i < B.size; i++) {
					evaluation += (float) Math.pow(value, i) * (int) B.get(i);
				}
				return evaluation;
			}

		case 'C':
			if (C.size == 0) {
				return 0;
			} else {
				float evaluation = 0;
				for (int i = 0; i < C.size; i++) {
					evaluation += (float) Math.pow(value, i) * (int) C.get(i);
				}
				return evaluation;
			}

		case 'R':
			if (R.size == 0) {
				return 0;
			} else {
				float evaluation = 0;
				for (int i = 0; i < R.size; i++) {
					evaluation += (float) Math.pow(value, i) * (int) R.get(i);
				}
				return evaluation;
			}
		default:
			throw null;
		}
	}

	@Override
	public int[][] add(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		SinglyLinkedList temp = new SinglyLinkedList();
		SinglyLinkedList temp1 = new SinglyLinkedList();
		if (poly1 == 'A' || poly2 == 'A' && !first.isEmpty()) {
			for (int i = 0; i < first.size(); i++) {
				temp1.add(first.get(i));
			}
			switch ((poly2 == 'A') ? poly1 : poly2) {
			case 'A':
				for (int i = 0; i < first.size(); i++) {
					temp.add(first.get(i));
				}
				break;
			case 'B':
				if (!B.isEmpty()) {

					for (int i = 0; i < B.size(); i++) {
						temp.add(B.get(i));
					}
					break;
				} else {
					return null;
				}
			case 'C':
				if (C.isEmpty()) {
					return null;
				} else {
					for (int i = 0; i < C.size(); i++) {
						temp.add(C.get(i));
					}
					break;
				}

			default:
				throw null;

			}
		} else if (poly1 == 'B' || poly2 == 'B' && !B.isEmpty()) {
			for (int i = 0; i < B.size(); i++) {
				temp1.add(B.get(i));
			}
			switch ((poly2 == 'B') ? poly1 : poly2) {
			case 'B':
				for (int i = 0; i < B.size(); i++) {
					temp.add(B.get(i));
				}
				break;
			case 'C':
				if (!C.isEmpty()) {
					for (int i = 0; i < C.size(); i++) {
						temp.add(C.get(i));
					}
					break;
				} else {
					return null;
				}
			default:
				throw null;

			}
		} else if (poly1 == 'C' || poly2 == 'C' && !C.isEmpty()) {
			for (int i = 0; i < C.size(); i++) {
				temp1.add(C.get(i));
			}
			switch ((poly2 == 'C') ? poly1 : poly2) {
			case 'C':
				for (int i = 0; i < C.size(); i++) {
					temp.add(C.get(i));
				}
				break;

			default:
				throw null;

			}
		} else {
			throw null;
		}
		R = new SinglyLinkedList();
		int i;
		for (i = 0; i < temp.size && i < temp1.size; i++) {
			R.add((int) temp.get(i) + (int) temp1.get(i));
		}
		if (i == temp.size) {
			for (int j = i; j < temp1.size; j++) {
				R.add((int) temp1.get(i));
			}
		} else {
			for (int j = i; j < temp.size; j++) {
				R.add((int) temp.get(i));
			}
		}
		int[][] result = new int[R.size][2];
		i = 0;
		for (int j = R.size - 1; j >= 0; j--) {
			result[i][1] = j;
			result[i][0] = (int) R.get(j);
			i++;
		}
		return result;

	}

	@Override
	public int[][] subtract(final char poly1, final char poly2) {
		SinglyLinkedList temp1 = new SinglyLinkedList();
		SinglyLinkedList temp2 = new SinglyLinkedList();
		if (poly1 == 'A' && !first.isEmpty()) {
			for (int i = 0; i < first.size(); i++) {
				temp1.add(first.get(i));
			}
			switch ((poly2 == 'A') ? poly1 : poly2) {
			case 'A':
				int[][] result = new int[1][2];
				result[0][0] = 0;
				result[0][1] = 0;
				return result;
			case 'B':
				if (!B.isEmpty()) {
					for (int i = 0; i < B.size(); i++) {
						temp2.add(B.get(i));
					}
					break;
				} else {
					return null;
				}
			case 'C':
				if (!C.isEmpty()) {
					for (int i = 0; i < C.size(); i++) {
						temp2.add(C.get(i));
					}
					break;
				} else {
					return null;
				}
			default:
				return null;
			}
		} else if (poly1 == 'B' && !B.isEmpty()) {
			for (int i = 0; i < B.size(); i++) {
				temp1.add(B.get(i));
			}
			switch ((poly2 == 'B') ? poly1 : poly2) {
			case 'B':
				int[][] result = new int[1][2];
				result[0][0] = 0;
				result[0][1] = 0;
				return result;
			case 'C':
				if (!C.isEmpty()) {
					for (int i = 0; i < C.size(); i++) {
						temp2.add(C.get(i));
					}
					break;
				} else {
					return null;
				}
			case 'A':
				if (!first.isEmpty()) {
					for (int i = 0; i < first.size(); i++) {
						temp2.add(first.get(i));
					}
					break;
				} else {
					return null;
				}
			default:
				return null;
			}
		} else if (poly1 == 'C' && !C.isEmpty()) {
			for (int i = 0; i < C.size(); i++) {
				temp1.add(C.get(i));
			}
			switch ((poly2 == 'C') ? poly1 : poly2) {
			case 'C':
				int[][] result = new int[1][2];
				result[0][0] = 0;
				result[0][1] = 0;
				return result;
			case 'B':
				if (!B.isEmpty()) {
					for (int i = 0; i < B.size(); i++) {
						temp2.add(B.get(i));
					}
					break;
				} else {
					return null;
				}
			case 'A':
				if (!first.isEmpty()) {
					for (int i = 0; i < first.size(); i++) {
						temp2.add(first.get(i));
					}
					break;
				} else {
					return null;
				}
			default:
				return null;
			}
		} else
			return null;
		R = new SinglyLinkedList();
		int i;
		for (i = 0; i < temp1.size && i < temp2.size; i++) {
			R.add((int) temp1.get(i) - (int) temp2.get(i));
		}
		if (i == temp1.size) {
			for (int j = i; j < temp2.size; j++) {
				R.add(0 - (int) temp2.get(i));
			}
		} else {
			for (int j = i; j < temp1.size; j++) {
				R.add((int) temp1.get(i));
			}
		}
		int[][] result1 = new int[R.size][2];
		i = 0;
		for (int j = R.size - 1; j >= 0; j--) {
			result1[i][1] = j;
			result1[i][0] = (int) R.get(j);
			i++;
		}
		return result1;
	}

	@Override
	public int[][] multiply(final char poly1, final char poly2) {
		if (poly1 == 'A' || poly2 == 'A' && !first.isEmpty()) {
			switch ((poly2 == 'A') ? poly1 : poly2) {
			case 'A':
				int[][] result = new int[first.size * 2 - 1][2];
				for (int i = 0; i < first.size * 2 - 1; i++) {
					int index = i;
					int count = 0;
					int sum = 0;
					if (i >= first.size) {
						for (int j = i; j >= first.size && count < first.size; j--) {
							count++;
							i--;
						}
					}
					for (int j = i; j >= 0 && count < first.size; j--) {
						sum += (int) first.get(j) * (int) first.get(count++);
					}
					result[index][0] = sum;
					result[index][1] = index;
					i = index;
				}
				R = new SinglyLinkedList();
				for (int i = 0; i < result.length; i++) {
					R.add(result[i][0]);
				}
				return result;
			case 'B':
				if (!B.isEmpty()) {
					int[][] result1 = new int[first.size + B.size - 1][2];
					if (first.size >= B.size) {
						for (int i = 0; i < first.size + B.size - 1; i++) {
							int index = i;
							int count = 0;
							int sum = 0;
							if (i >= first.size) {
								for (int j = i; j >= first.size && count < B.size; j--) {
									count++;
									i--;
								}
							}
							for (int j = i; j >= 0 && count < B.size; j--) {
								sum += (int) first.get(j) * (int) B.get(count++);
							}
							result1[index][0] = sum;
							result1[index][1] = index;
							i = index;
						}
					} else {
						for (int i = 0; i < first.size + B.size - 1; i++) {
							int index = i;
							int count = 0;
							int sum = 0;
							if (i >= B.size) {
								for (int j = i; j >= B.size && count < first.size; j--) {
									count++;
									i--;
								}
							}
							for (int j = i; j >= 0 && count < first.size; j--) {
								sum += (int) B.get(j) * (int) first.get(count++);
							}
							result1[index][0] = sum;
							result1[index][1] = index;
							i = index;
						}
					}
					R = new SinglyLinkedList();
					for (int i = 0; i < result1.length; i++) {
						R.add(result1[i][0]);
					}
					return result1;
				} else {
					return null;
				}
			case 'C':
				if (!C.isEmpty()) {
					int[][] result1 = new int[first.size + C.size - 1][2];
					if (first.size >= C.size) {
						for (int i = 0; i < first.size + C.size - 1; i++) {
							int index = i;
							int count = 0;
							int sum = 0;
							if (i >= first.size) {
								for (int j = i; j >= first.size && count < C.size; j--) {
									count++;
									i--;
								}
							}
							for (int j = i; j >= 0 && count < C.size; j--) {
								sum += (int) first.get(j) * (int) C.get(count++);
							}
							result1[index][0] = sum;
							result1[index][1] = index;
							i = index;
						}
					} else {
						for (int i = 0; i < first.size + C.size - 1; i++) {
							int index = i;
							int count = 0;
							int sum = 0;
							if (i >= C.size) {
								for (int j = i; j >= C.size && count < first.size; j--) {
									count++;
									i--;
								}
							}
							for (int j = i; j >= 0 && count < first.size; j--) {
								sum += (int) C.get(j) * (int) first.get(count++);
							}
							result1[index][0] = sum;
							result1[index][1] = index;
							i = index;
						}
					}
					R = new SinglyLinkedList();
					for (int i = 0; i < result1.length; i++) {
						R.add(result1[i][0]);
					}
					return result1;
				} else {
					return null;
				}
			default:
				return null;
			}
		} else if (poly1 == 'B' || poly2 == 'B' && !B.isEmpty()) {
			switch ((poly2 == 'B') ? poly1 : poly2) {
			case 'B':
				int[][] result = new int[first.size + B.size - 1][2];
				for (int i = 0; i < 2 * B.size - 1; i++) {
					int index = i;
					int count = 0;
					int sum = 0;
					if (i >= B.size) {
						for (int j = i; j >= B.size && count < B.size; j--) {
							count++;
							i--;
						}
					}
					for (int j = i; j >= 0 && count < B.size; j--) {
						sum += (int) B.get(j) * (int) B.get(count++);
					}
					result[index][0] = sum;
					result[index][1] = index;
					i = index;
				}
				R = new SinglyLinkedList();
				for (int i = 0; i < result.length; i++) {
					// System.out.println("h");
					R.add(result[i][0]);
				}
				return result;
			case 'C':
				if (!C.isEmpty()) {
					int[][] result1 = new int[C.size + B.size - 1][2];
					if (C.size >= B.size) {
						for (int i = 0; i < C.size + B.size - 1; i++) {
							int index = i;
							int count = 0;
							int sum = 0;
							if (i >= C.size) {
								for (int j = i; j >= C.size && count < B.size; j--) {
									count++;
									i--;
								}
							}
							for (int j = i; j >= 0 && count < B.size; j--) {
								sum += (int) C.get(j) * (int) B.get(count++);
							}
							result1[index][0] = sum;
							result1[index][1] = index;
							i = index;
						}
					} else {
						for (int i = 0; i < C.size + B.size - 1; i++) {
							int index = i;
							int count = 0;
							int sum = 0;
							if (i >= B.size) {
								for (int j = i; j >= B.size && count < C.size; j--) {
									count++;
									i--;
								}
							}
							for (int j = i; j >= 0 && count < C.size; j--) {
								sum += (int) B.get(j) * (int) C.get(count++);
							}
							result1[index][0] = sum;
							result1[index][1] = index;
							i = index;
						}
					}
					R = new SinglyLinkedList();
					for (int i = 0; i < result1.length; i++) {
						R.add(result1[i][0]);
					}
					return result1;
				} else {
					return null;
				}
			default:
				return null;
			}
		} else if (poly1 == 'C' || poly2 == 'C' && !C.isEmpty()) {

			switch ((poly2 == 'C') ? poly1 : poly2) {
			case 'C':
				int[][] result = new int[2 * C.size - 1][2];
				for (int i = 0; i < 2 * C.size - 1; i++) {
					int index = i;
					int count = 0;
					int sum = 0;
					if (i >= first.size) {
						for (int j = i; j >= C.size && count < C.size; j--) {
							count++;
							i--;
						}
					}
					for (int j = i; j >= 0 && count < C.size; j--) {
						sum += (int) C.get(j) * (int) C.get(count++);
					}
					result[index][0] = sum;
					result[index][1] = index;

					i = index;
				}
				R = new SinglyLinkedList();
				for (int i = 0; i < result.length; i++) {
					R.add(result[i][0]);
				}
				return result;
			default:
				return null;
			}
		}
		return null;
	}
}
